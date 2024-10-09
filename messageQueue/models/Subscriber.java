package com.pranjli.machinecoding.messageQueue.models;

import com.pranjli.machinecoding.messageQueue.dao.InMemoryDAO;

import java.util.ArrayList;
import java.util.List;

public class Subscriber {
   //offset should be thread safe since it can be change while consuming msg/setting offset
    int offset =0;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public Subscriber(String id) {
        this.id = id;
    }

    List<Topic> subscribedTopics = new ArrayList<>();
    String id;

    public void subscribe(String topic){
        Topic t = InMemoryDAO.getTopic(topic);
        subscribedTopics.add(t);
        t.getSubscribers().add(this);
        InMemoryDAO.addSubscriber(topic,id);
    }

    public void readMessage(Topic t){
        if(offset!=0){
            List<String> msg = t.getMessage();
            for(int i =offset-1; i< msg.size();i++){
                String m = msg.get(i);
                System.out.println("Msg "+m +" read by subscriber "+id);
            }
        }
        else
        System.out.println("Msg "+t.getMessage().getLast() +" read by subscriber "+id);
    }
}
