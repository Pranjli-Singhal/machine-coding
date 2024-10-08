package com.pranjli.machinecoding.librarymanagement.service;

import com.pranjli.machinecoding.librarymanagement.models.Book;
import com.pranjli.machinecoding.librarymanagement.models.Library;
import com.pranjli.machinecoding.librarymanagement.models.Rack;
import com.pranjli.machinecoding.librarymanagement.models.User;

import java.util.*;

public class Manager {
    Library lib;
    Map<String,User> users = new HashMap<>();
    Map<String, Book> copies = new HashMap<>();
    public void createLibrary(int id, int racks){
        lib = Library.getInstance(id,racks);
        System.out.println("Created library with "+racks+" racks");
    }

    //Thread safe
    public synchronized void addBooks(String bookId, String title, List<String> authors,List<String> publishers,List<String> copyIds){
        List<Rack> racks = lib.getRacks();
        Book book = new Book(bookId,title,authors,publishers);

        int numBooks = copyIds.size();
        int avlRacks =0;


        for(Rack rack : racks){
            boolean avl = true;
                if(rack.getBooks().containsKey(bookId))
                {
                    avl = false;
                    break;
                }
            if(avl)
                avlRacks++;
        }

        if(avlRacks < numBooks){
            System.out.println("Rack not available");
            return;
        }

        List<Integer> occupiedRacks = new ArrayList<>();
        int j =0;
        for(int i =0; i< lib.getNumRacks(); i++){
            Rack rack = racks.get(i);
            if(!rack.getBooks().containsKey(bookId)){
               rack.getBooks().put(bookId,book);
               rack.getCopyToBook().put(copyIds.get(j),bookId);
               copies.put(copyIds.get(j),book);
                j++;
                occupiedRacks.add(i);
            }
            if(j == numBooks){
                System.out.print("Added Book to racks: ");
                for(int r : occupiedRacks){
                    System.out.print(r+1+",");
                }
                return;
            }
        }
    }

    public synchronized void remove(String bookId){
        List<Rack> racks = lib.getRacks();
        for(int i =0; i< racks.size();i++){
            Rack rack = racks.get(i);
            if(rack.getCopyToBook().containsKey(bookId)){
                System.out.println("Removed book copy: "+bookId+" from rack: "+i);

                rack.getBooks().remove(rack.getCopyToBook().get(bookId));
                rack.getCopyToBook().remove(bookId);
                return;
            }
        }
        System.out.println("Invalid Book Copy ID");
    }

    public synchronized void  borrow(String bookId, String userId, String due){
        if(users.get(userId) == null)
            users.put(userId,new User(userId));
        User user = users.get(userId);
        if(user.getBorrowed().size() > 5)
        {
            System.out.println("Overlimit");
            return;
        }

        List<Rack> racks = lib.getRacks();
        for(int i =0; i< racks.size();i++){
            Rack rack = racks.get(i);
            if(rack.getBooks().containsKey(bookId)){
                System.out.println("Borrowed book copy: "+bookId+" from rack: "+i);
                rack.getBooks().remove(bookId);
                rack.getCopyToBook().remove(rack.getCopyToBook().get(bookId));
                List<String> temp = new ArrayList<>(Arrays.asList(bookId,due));
                user.getBorrowed().add(temp);

                return;
            }
        }
        System.out.println("Invalid Book ID");
    }

    public synchronized void borrowCopy(String bookId, String userId, String due){
        if(users.get(userId) == null)
            users.put(userId,new User(userId));
        User user = users.get(userId);
        if(user.getBorrowedBooks() > 5)
        {
            System.out.println("Overlimit");
            return;
        }

        List<Rack> racks = lib.getRacks();
        for(int i =0; i< racks.size();i++){
            Rack rack = racks.get(i);
            if(rack.getCopyToBook().containsKey(bookId)){
                System.out.println("Borrowed book copy: "+bookId+" from rack: "+i);
                rack.getBooks().remove(rack.getCopyToBook().get(bookId));
                rack.getCopyToBook().remove(bookId);
                return;
            }
        }
        System.out.println("Invalid Book copy ID");
    }

    public void returnBook(String bookId){
        if(!copies.containsKey(bookId)){
            System.out.println("Invalid Book copy Id");
            return;
        }
        Book book = copies.get(bookId);
        addBooks(book.getId(),book.getTitle(),book.getAuthors(),book.getPublishers(),new ArrayList<>(List.of(bookId)));

    }

    public void print(String user){
        User u =users.get(user);
        List<List<String>> books = u.getBorrowed();

        for(List<String> b : books){
            System.out.println("Book copy: "+b.get(0)+ " " +b.get(1));
        }

    }

    //add feature to support printing borrrowed by and rack -1
    public void search(String key, String value){

       for(Map.Entry<String, Book> entry : copies.entrySet()){
           Book b = entry.getValue();
           if((Objects.equals(key, "book_id") && Objects.equals(b.getId(), value)) ||(Objects.equals(key, "author") && b.getAuthors().contains(value) )||
                   (Objects.equals(key, "publisher") && b.getPublishers().contains(value))){

               List<Rack> racks = lib.getRacks();
               for(int i =0; i< racks.size();i++){
                   Rack r = racks.get(i);
                   for(Map.Entry<String, Book> entry2 : r.getBooks().entrySet()){

                       if(b == entry2.getValue()){

                           System.out.println("Book Copy: "+entry.getKey()+" "+ b.getId()+" "+i);

                       }
                   }
               }

           }

       }


    }
}
