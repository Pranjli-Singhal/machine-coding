package com.pranjli.machinecoding.cache;

import com.pranjli.machinecoding.cache.models.DLLNode;

import java.util.Map;


public class Main {
    public static void main(String[] args) {


      Cache cache = new Cache();// using LRU
      Map<String, DLLNode> entries = cache.getReference();

        cache.putEntry("A", "first");
        cache.putEntry("B", "second");
        cache.putEntry("C", "third");
        for(Map.Entry<String,DLLNode> entry : entries.entrySet()){
            System.out.println("Key is : "+ entry.getKey()+ " value is : "+ entry.getValue().getVal());
        }

        System.out.println(cache.getValue("A"));
        cache.putEntry("B","newSecond");
        cache.putEntry("D", "fourth");

        System.out.println(cache.getValue("A"));
        for(Map.Entry<String,DLLNode> entry : entries.entrySet()){
            System.out.println("Key is : "+ entry.getKey()+ " value is : "+ entry.getValue().getVal());
        }


    }
}