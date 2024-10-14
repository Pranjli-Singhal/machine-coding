package com.pranjli.machinecoding.threadpool.workers;

import com.pranjli.machinecoding.threadpool.models.Task;

public class ThreadWorker {
    public synchronized void run(Task t) throws InterruptedException {
        if(t.getId()%2==0)
        Thread.sleep(10000);
        t.run();
    }
}
