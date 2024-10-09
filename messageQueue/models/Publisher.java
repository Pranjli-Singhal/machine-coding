package com.pranjli.machinecoding.messageQueue.models;

public class Publisher {
    String id;
    Queue queue = new Queue();

    public Publisher(String id) {
        this.id = id;
    }

    public void publish(String t, String msg){
        queue.publish(t,msg);
    }

}
