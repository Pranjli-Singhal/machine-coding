package com.pranjli.machinecoding.messageQueue.models;

import com.pranjli.machinecoding.messageQueue.service.QueueService;

public class Publisher {
    String id;
    QueueService queueService = new QueueService();

    public Publisher(String id) {
        this.id = id;
    }

    public void publish(String t, String msg){
        queueService.publish(t,msg);
    }

    public void createTopic(String topic){
        queueService.createTopic(topic);
    }

}
