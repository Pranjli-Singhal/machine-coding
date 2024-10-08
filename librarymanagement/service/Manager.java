package com.pranjli.machinecoding.librarymanagement.service;

import com.pranjli.machinecoding.librarymanagement.models.Book;
import com.pranjli.machinecoding.librarymanagement.models.Library;
import com.pranjli.machinecoding.librarymanagement.models.Rack;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Manager {
    Library lib;
    public void createLibrary(int id, int racks){
        lib = Library.getInstance(id,racks);
        System.out.println("Created library with "+racks+" racks");
    }

    public void addBooks(String bookId, String title, List<String> authors,List<String> publishers,List<String> copyId){
        List<Rack> racks = lib.getRacks();
        Book book = new Book(bookId,title,authors,publishers);
        List<String> copyIds = new ArrayList<>();
        copyIds.add(bookId);
        copyIds.addAll(copyId);
        int numBooks = copyIds.size();
        int avlRacks =0;


        for(Rack rack : racks){
            boolean avl = true;
            for(String copy : copyIds)
                if(rack.getBooks().containsKey(copy))
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
               rack.getBooks().put(copyIds.get(j),book);
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

    public void remove(String bookId){
        List<Rack> racks = lib.getRacks();
        for(int i =0; i< racks.size();i++){
            Rack rack = racks.get(i);
            if(rack.getBooks().containsKey(bookId)){
                System.out.println("Removed book copy: "+bookId+" from rack: "+i);
                rack.getBooks().remove(bookId);
                return;
            }
        }
        System.out.println("Invalid Book Copy ID");

    }
}
