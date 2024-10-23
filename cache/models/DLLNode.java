package com.pranjli.machinecoding.cache.models;

public class DLLNode {
    //chnge structure to make list here not node
    String val;
    String key;
    DLLNode prev;
    DLLNode nxt;

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public DLLNode getPrev() {
        return prev;
    }

    public void setPrev(DLLNode prev) {
        this.prev = prev;
    }

    public DLLNode getNxt() {
        return nxt;
    }

    public void setNxt(DLLNode nxt) {
        this.nxt = nxt;
    }

    public DLLNode(String key,String val){
        this.val = val;
        this.key = key;
        this.prev = null;
        this.nxt = null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public DLLNode(String val, DLLNode prev, DLLNode nxt) {
        this.val = val;
        this.prev = prev;
        this.nxt = nxt;
    }
}
