package com.pranjli.machinecoding.messageQueue.dao;

import com.pranjli.machinecoding.messageQueue.models.Topic;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDAO {
    static Map<String, Topic> topic = new HashMap<>();

    public static Map<String, Topic> getTopics() {
        return topic;
    }

    static Map<String, String> subscribers = new HashMap<>();

    public static void createTopic(String t){
        topic.put(t, new Topic(t));
    }

    public static Topic getTopic(String t){
        return topic.get(t);
    }

    public static void addSubscriber(String t, String u){
        subscribers.put(t,u);
    }
}
