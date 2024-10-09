package com.pranjli.machinecoding.messageQueue.models;

import com.pranjli.machinecoding.messageQueue.dao.InMemoryDAO;
import com.pranjli.machinecoding.messageQueue.worker.SubscriberWorker;
import com.pranjli.machinecoding.messageQueue.worker.TopicWorker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


// it should be exposing APIs which one can use e.g. publish, subscribe,resetOffSet
public class Queue {
    Map<String, Topic> topic;

    public Queue() {
        this.topic = new HashMap<>();
    }

    public void createTopic(String t){
        topic.put(t, new Topic(t));
    }

    public void publish(String tname, String msg){
        Topic t = topic.get(tname);
        t.addMessage(msg);
        //to Support async publishing; we don't want caller to be blocked
        new Thread(() -> TopicWorker.publish(t)).start();
    }

    public void subscribe(Subscriber sub, String topi){
        Topic t = topic.get(topi);
        sub.getSubscribedTopics().add(t);
        t.getSubscribers().add(sub);
    }

    public void setOffset(Subscriber sub,int offset, String topi) {
        sub.getOffset().set(offset);//(new AtomicInteger(offset));
        new Thread(() -> TopicWorker.publish(topic.get(topi))).start();
    }
}
