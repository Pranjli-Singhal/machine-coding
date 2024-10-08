package com.pranjli.machinecoding.librarymanagement.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Used Singleton Pattern
public class Library {
    int numRacks;
    int id;
    List<Rack> racks;
    private static volatile Library lib;

    private Library(int id, int numRacks) {
        this.id =id;
        this.numRacks = numRacks;
        this.racks = new ArrayList<>();
        for(int i =0; i< numRacks;i++)
            racks.add(new Rack(new HashMap<>(),new HashMap<>()));
    }

    public static Library getInstance(int id, int numRacks){
        if(lib == null){
            synchronized (Library.class){
                if(lib == null)
                    lib = new Library(id,numRacks);
            }
        }
        return lib;
    }

    public int getNumRacks() {
        return numRacks;
    }

    public void setNumRacks(int numRacks) {
        this.numRacks = numRacks;
    }

    public List<Rack> getRacks() {
        return racks;
    }

    public void setRacks(List<Rack> racks) {
        this.racks = racks;
    }


}
