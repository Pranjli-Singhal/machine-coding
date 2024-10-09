package com.pranjli.machinecoding.messageQueue.service;

import com.pranjli.machinecoding.messageQueue.dao.InMemoryDAO;
import com.pranjli.machinecoding.messageQueue.models.Subscriber;
import com.pranjli.machinecoding.messageQueue.models.Topic;

import java.util.List;

public class QueueService {
    public QueueService() {
    }

    public void createTopic(String topic){
        InMemoryDAO.createTopic(topic);
    }

    public void publish(String topic, String msg){
        Topic t = InMemoryDAO.getTopic(topic);
        t.getMessage().add(msg);
        List<Subscriber> subscriberList = t.getSubscribers();
        for(Subscriber sub : subscriberList){
            sub.readMessage(t);
        }
    }


}
