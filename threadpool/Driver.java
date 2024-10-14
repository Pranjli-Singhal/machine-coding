package com.pranjli.machinecoding.threadpool;

import com.pranjli.machinecoding.threadpool.models.Task;
import com.pranjli.machinecoding.threadpool.models.ThreadPool;

public class Driver {

    public static void main(String[] args){
        ThreadPool pool = new ThreadPool(3);
        pool.submit(new Task(1));
        pool.submit(new Task(2));
        pool.submit(new Task(3));
        try {
            pool.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        pool.submit(new Task(4));
        pool.submit(new Task(5));


    }
}
