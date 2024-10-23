package com.pranjli.machinecoding.cache;

import com.pranjli.machinecoding.cache.models.DLLNode;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    //support various eviction policy
    Map<String, DLLNode> reference;
    DLLNode head;

    public Map<String, DLLNode> getReference() {
        return reference;
    }

    DLLNode tail;

    private static int CACHE_DEFAULT_SIZE = 3;

    public Cache() {
        this.reference = new HashMap<>();
        this.head = null;
    }

    public String getValue(String key){
        String val = reference.get(key).getVal();
        deleteEntry(key);
        putEntry(key,val);
        return val;
    }

    public void deleteEntry(String key){
       // System.out.println("Deleting entry with key"+key);
        DLLNode temp = reference.get(key);
        if(temp == head){
            head = head.getNxt();
            head.setPrev(null);
        }
        else{
        temp.getPrev().setNxt(temp.getNxt());
        temp.getNxt().setPrev(temp.getPrev());}

        reference.remove(key);
    }

    public void putEntry(String key, String value){
        if(reference.get(key) != null){
            deleteEntry(key);
            putEntry(key,value);
        } else{
            if(reference.size() >= CACHE_DEFAULT_SIZE){
                reference.remove(head.getKey());
                head = head.getNxt();
                head.setPrev(null);

            }
            DLLNode temp = new DLLNode(key,value);
            if(head == null) {
                head = temp;
                tail = head;

            }
            else {
                tail.setNxt(temp);
                temp.setPrev(tail);
                tail = temp;
            }
            reference.put(key, temp);

        }
    }
}
