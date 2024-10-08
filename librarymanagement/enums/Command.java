package com.pranjli.machinecoding.librarymanagement.enums;

import java.util.HashMap;
import java.util.Map;

public enum Command {
    CREATE_LIBRARY("create_library"),
    ADD_BOOK("add_book"),
    REMOVE_BOOK_COPY("remove_book_copy"),
    BORROW_BOOK("borrow_book"),
    BORROW_BOOK_COPY("borrow_book_copy"),
    PRINT_BORROWED("print_borrowed"),
    SEARCH("search"),
    EXIT("exit");

    String desc;
    private static Map<String, Command> cmd = new HashMap<>();

    Command(String desc) {
        this.desc = desc;
    }

    static {
        for(Command c : values())
            cmd.put(c.desc,c);
    }

    public static Command of(String s){
        return cmd.get(s);
    }
}
