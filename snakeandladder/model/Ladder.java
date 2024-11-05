package com.pranjli.machinecoding.snakeandladder.model;

//Use Factory Pattern
public class Ladder implements Obstacle{
    int strt;
    int end;

    public Ladder(int strt, int end){
        this.strt = strt;
        this.end = end;
    }

    public int getStart(){
        return this.strt;
    }

    public int getEnd(){
        return this.end;
    }
}
