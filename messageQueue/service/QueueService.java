package com.pranjli.machinecoding.messageQueue.service;

import com.pranjli.machinecoding.messageQueue.dao.InMemoryDAO;
import com.pranjli.machinecoding.messageQueue.models.Subscriber;
import com.pranjli.machinecoding.messageQueue.models.Topic;

import java.util.List;


// it should be exposing APIs which one can use e.g. publish, subscribe,resetOffSet
public class QueueService {
    public QueueService() {
    }

    public void createTopic(String topic){
        InMemoryDAO.createTopic(topic);
    }

    public void publish(String topic, String msg){
        Topic t = InMemoryDAO.getTopic(topic);
        //adding to topic should be thread safe
        t.getMessage().add(msg);
        List<Subscriber> subscriberList = t.getSubscribers();
        //cuurently it's sequential; make it run parallely
        for(Subscriber sub : subscriberList){
            sub.readMessage(t);
        }
    }


}
