package com.pranjli.machinecoding.messageQueue;

import com.pranjli.machinecoding.messageQueue.models.Publisher;
import com.pranjli.machinecoding.messageQueue.models.Subscriber;
import com.pranjli.machinecoding.messageQueue.service.QueueService;

public class Driver {

    public static void main(String[] args){

        Publisher pub1 = new Publisher("pub1");
        Subscriber sub1 = new Subscriber("sub1");
        Subscriber sub2 = new Subscriber("sub2");
        Subscriber sub3 = new Subscriber("sub3");

        //there should be a queue with multiple topics
        pub1.createTopic("topic1");
        pub1.createTopic("topic2");

        pub1.publish("topic1", "Msg1");

        sub1.subscribe("topic1");
        pub1.publish("topic1","Msg2");

        sub1.setOffset(1);
        pub1.publish("topic1","Msg3");
    }
}
