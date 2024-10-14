package com.pranjli.machinecoding.threadpool.models;

import com.pranjli.machinecoding.threadpool.workers.ThreadWorker;

import java.util.*;

public class ThreadPool {
    int numThreads;
    List<Task> queue;
    ThreadWorker worker = new ThreadWorker();

    public ThreadPool(int numThreads) {
        this.numThreads = numThreads;
        queue = new ArrayList<>();
        for(int i =0;i< numThreads;i++)
            new Thread(() -> worker.run(new Task(i))).start();

    }



    public void run() throws InterruptedException {

        for(int i =0; i< numThreads;i++){
            Task t = queue.get(i);
            synchronized (ThreadPool.class){
                worker.run(t);}
            }
    }

    public void submit(Task task){
        queue.add(task);
    }
}
