package com.pranjli.machinecoding.threadpool;

import com.pranjli.machinecoding.threadpool.models.Task;
import com.pranjli.machinecoding.threadpool.models.ThreadPool;
import com.pranjli.machinecoding.threadpool.workers.ThreadWorker;

public class Driver {

    public static void main(String[] args){
        ThreadPool pool = new ThreadPool(3);

        pool.submit(new Task(1));
        pool.submit(new Task(2));
        pool.submit(new Task(3));
        pool.submit(new Task(4));
        pool.submit(new Task(5));

        pool.shutdown();


    }
}
