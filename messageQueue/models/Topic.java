package com.pranjli.machinecoding.messageQueue.models;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    String id;
    List<String> msg = new ArrayList<>();

    public Topic(String id) {
        this.id = id;
    }

    List<Subscriber> subscribers = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getMessage() {
        return msg;
    }

    public void setMsg(List<String> msg) {
        this.msg = msg;
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }
}
