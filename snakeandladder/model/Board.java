package com.pranjli.machinecoding.snakeandladder.model;

import java.util.List;

public class Board {

    private static Board board;
    private int size;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    private List<Player> players;

    //Singleton pattern
    private Board(int size, List<Snake> snakes, List<Ladder> ladders, List<Player> players){
        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
        this.players = players;
    }

    public static Board getInstance(int size, List<Snake> snakes, List<Ladder> ladders, List<Player> players){
        if(board == null){
            synchronized (Board.class) { //Making singleton thread safe
                if(board == null)                // double check
                    return new Board(size, snakes, ladders, players);
            }
        }
        return board;

    }

    public List<Player> getPlayers(){
        return this.players;
    }

    public List<Snake> getSnakes(){
        return this.snakes;
    }

    public List<Ladder> getLadders(){
        return this.ladders;
    }
}
