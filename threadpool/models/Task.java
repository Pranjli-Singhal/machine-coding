package com.pranjli.machinecoding.threadpool.models;

public class Task implements Runnable{

    int id;

    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread"+ id+" is running");
    }

    public int getId() {
        return id;
    }
}
