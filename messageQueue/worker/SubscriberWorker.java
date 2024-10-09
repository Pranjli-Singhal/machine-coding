package com.pranjli.machinecoding.messageQueue.worker;

import com.pranjli.machinecoding.messageQueue.models.Subscriber;
import com.pranjli.machinecoding.messageQueue.models.Topic;


public class SubscriberWorker implements Runnable {

    Topic topic;
    final Subscriber subscriber;

    public SubscriberWorker(Topic topic, Subscriber subscriber) {
        this.topic = topic;
        this.subscriber = subscriber;
    }

    @Override
    public void run() {
        //Reads on same subscriber are sequential
        synchronized (subscriber) {
            do {
                int offset = subscriber.getOffset().get();
              /*  From official documentation :
                A thread can also wake up without being notified, interrupted, or timing out, a so-called spurious
                 wakeup. While this will rarely occur in practice, applications must guard against it by testing for
                 the condition that should have caused the thread to be awakened, and continuing to wait if the
                 condition is not satisfied. In other words, waits should always occur in loops.
                 Hence while loop and not if check
               */
                while (offset == topic.getMessage().size()) {
                    try {
                        subscriber.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                String m = topic.getMessage().get(offset);
                System.out.println( m + " read by subscriber " + subscriber.getId());
                subscriber.getOffset().compareAndSet(offset, offset + 1);
            }
            while (true);
        }

    }
    public void wakeUp() {
        synchronized (subscriber) {
            subscriber.notify();
        }
    }

}
