package com.pranjli.machinecoding.threadpool.models;

import com.pranjli.machinecoding.threadpool.workers.ThreadWorker;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

//From Medium blog: Instead of creating a new thread for every task, which can be inefficient and can cause resource contention, a thread pool allows for a set of threads to be created once and then reused for multiple tasks.Instead of creating a new thread for every task, which can be inefficient and can cause resource contention, a thread pool allows for a set of threads to be created once and then reused for multiple tasks.
public class ThreadPool {

    //The BlockingQueue allows threads to wait for new tasks when the queue is empty and only accepts new tasks when space is available, preventing the system from being overloaded with too many tasks at once.
    BlockingQueue<Task> queue;
    //Producer-Consumer Pattern
   // The LinkedBlockingQueue is used to hold tasks. Tasks are produced by the main thread and consumed by the worker threads.
    Thread[] workers;
    Boolean shutDown;

    public ThreadPool(int numThreads) {
        queue = new LinkedBlockingDeque<>();
        workers = new Thread[numThreads];
        shutDown = false;
        for(int i =0;i< numThreads;i++){
            workers[i] = new ThreadWorker(queue,shutDown);
            workers[i].start();
        }

    }

    public void submit(Task task){
        queue.add(task);
    }

    public void shutdown(){
        shutDown = true;

    }
}
