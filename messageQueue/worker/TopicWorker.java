package com.pranjli.machinecoding.messageQueue.worker;

import com.pranjli.machinecoding.messageQueue.models.Subscriber;
import com.pranjli.machinecoding.messageQueue.models.Topic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopicWorker {

    static Map<String,SubscriberWorker> workerMap = new HashMap<>();
    public static void publish(Topic t) {
        List<Subscriber> subscriberList = t.getSubscribers();

        for (Subscriber sub : subscriberList) {
            if(workerMap.get(sub.getId()) == null) {
                workerMap.put(sub.getId(), new SubscriberWorker(t, sub));

                SubscriberWorker subscriberWorker = workerMap.get(sub.getId());
                new Thread(subscriberWorker).start();
            }
            SubscriberWorker subscriberWorker = workerMap.get(sub.getId());
            subscriberWorker.wakeUp();
        }

    }


}
