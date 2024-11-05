package com.pranjli.machinecoding.snakeandladder.service;

import com.pranjli.machinecoding.snakeandladder.model.Board;
import com.pranjli.machinecoding.snakeandladder.model.Ladder;
import com.pranjli.machinecoding.snakeandladder.model.Player;
import com.pranjli.machinecoding.snakeandladder.model.Snake;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Initialize {
   //Why static function
    public static Board getGame(){
//support that i/p is valid i.e no new snake /ladder on already inserted position
        Scanner scan = new Scanner(System.in);
        int numSnake = scan.nextInt();
        List<Snake> snakes = new ArrayList<>();
        System.out.println("No. of snakes = "+numSnake);
        while(numSnake > 0){
            int strt = scan.nextInt();
            int end = scan.nextInt();
            snakes.add(new Snake(strt,end));
            numSnake--;
        }
        int numLadders = scan.nextInt();
        List<Ladder> ladders = new ArrayList<>();
        System.out.println("No. of ladders = "+numLadders);
        while(numLadders > 0){
            int strt = scan.nextInt();
            int end = scan.nextInt();
            ladders.add(new Ladder(strt,end));
            numLadders--;
        }
        int numPlayers = scan.nextInt();
        System.out.println("No. of players = "+numPlayers);
        List< Player> players = new ArrayList<>();
        while(numPlayers > 0){

            String name= scan.next();
            players.add(new Player(name));
            numPlayers--;
        }
        System.out.println("Initialized");
        return Board.getInstance(100,snakes, ladders, players);

    }
}
