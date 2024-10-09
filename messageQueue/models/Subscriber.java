package com.pranjli.machinecoding.messageQueue.models;

import com.pranjli.machinecoding.messageQueue.dao.InMemoryDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Subscriber {
    public List<Topic> getSubscribedTopics() {
        return subscribedTopics;
    }

    //offset should be thread safe since it can be change while consuming msg/setting offset
    AtomicInteger offset ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AtomicInteger getOffset() {
        return offset;
    }

    public void setOffset(AtomicInteger offset) {
        this.offset = offset;
    }

    public Subscriber(String id) {
        this.id = id;
        this.offset = new AtomicInteger(0);
    }

    List<Topic> subscribedTopics = new ArrayList<>();
    String id;

}
