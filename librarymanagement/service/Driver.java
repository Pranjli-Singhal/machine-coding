package com.pranjli.machinecoding.librarymanagement.service;

import com.pranjli.machinecoding.librarymanagement.enums.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//Single Responsibility Principle
public class Driver {
    private static final Manager manager = new Manager();
    public static void run(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            String in = scanner.nextLine();
            String[] inp = in.trim().split(" ");
            Command option = Command.of(inp[0]);

            try {
                switch (option) {
                    case Command.CREATE_LIBRARY: {
                        manager.createLibrary(Integer.parseInt(inp[1]), Integer.parseInt(inp[2]));
                        break;
                    }
                    case Command.ADD_BOOK: {
                        List<String> authors = new ArrayList<>(Arrays.asList(inp[3].split(",")));
                        List<String> publishers = new ArrayList<>(Arrays.asList(inp[4].split(",")));
                        List<String> copyIds = new ArrayList<>(Arrays.asList(inp[5].split(",")));
                        manager.addBooks(inp[1], inp[2], authors, publishers, copyIds);
                        break;
                    }
                    case Command.REMOVE_BOOK_COPY: {
                        manager.remove(inp[1]);
                        break;
                    }
                    case Command.EXIT:
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
