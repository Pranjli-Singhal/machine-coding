package com.pranjli.machinecoding.splitwise;

import com.pranjli.machinecoding.splitwise.service.SplitwiseService;

public class Driver {

    public static void main(String[] args){
        SplitwiseService.initialize();
        SplitwiseService.drive();
    }
}
