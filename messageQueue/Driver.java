package com.pranjli.machinecoding.messageQueue;

import com.pranjli.machinecoding.messageQueue.models.Queue;
import com.pranjli.machinecoding.messageQueue.models.Subscriber;

public class Driver {

    public static void main(String[] args) throws Exception{

        Queue queue = new Queue();
        queue.createTopic("topic1");
        queue.createTopic("topic2");

        Subscriber sub1 = new Subscriber("sub1");
        Subscriber sub2 = new Subscriber("sub2");
        Subscriber sub3 = new Subscriber("sub3");
        queue.subscribe(sub1,"topic1");
        queue.subscribe(sub2,"topic1");
        queue.publish("topic1", "Msg1");
        Thread.sleep(15000);

        queue.publish("topic1","Msg2");
        queue.publish("topic1","Msg3");
        queue.setOffset(sub1,0,"topic1");
    }
}
