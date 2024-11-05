package com.pranjli.machinecoding.snakeandladder;


import com.pranjli.machinecoding.snakeandladder.model.Board;
import com.pranjli.machinecoding.snakeandladder.service.Game;
import com.pranjli.machinecoding.snakeandladder.service.Initialize;

public class Main {
    public static void main(String[] args) {

        Board board = Initialize.getGame();
        Game.play(board);


    }
}