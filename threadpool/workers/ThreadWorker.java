package com.pranjli.machinecoding.threadpool.workers;

import com.pranjli.machinecoding.threadpool.models.Task;

import java.util.concurrent.BlockingQueue;

public class ThreadWorker extends Thread{

    BlockingQueue<Task> queue;
    Boolean shutDown;

    public ThreadWorker(BlockingQueue<Task> queue,Boolean shutDown) {
        this.queue = queue;
        this.shutDown = shutDown;
    }

    public void run()  {
                while (!shutDown || !queue.isEmpty()) {
                    try {

                       Task t= queue.take();
                       t.run();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
    }
}
