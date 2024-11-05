package com.pranjli.machinecoding.snakeandladder.service;

import com.pranjli.machinecoding.snakeandladder.model.Board;
import com.pranjli.machinecoding.snakeandladder.model.Ladder;
import com.pranjli.machinecoding.snakeandladder.model.Snake;
import com.pranjli.machinecoding.snakeandladder.util.DiceUtil;

import java.util.*;

public class Game {
    public static void play(Board board){
        int n = board.getPlayers().size();
        Queue<Integer> players = new LinkedList<>();
        Map<Integer, Integer> position = new HashMap<>();
        for(int i =0; i< n; i++)
        {
            players.add(i);
            position.put(i,0);
        }
        //Can support multiple knock offs of players
        while(players.size()> 1){
            int turn = players.poll();
            players.add(turn);
            String pName = board.getPlayers().get(turn).getName();

            int dice = DiceUtil.throwDice(2);
            System.out.println(pName + " Dice threw "+dice);
            int curr = position.get(turn);
            if(curr+dice > 100){
                System.out.println("Number is greater than 100");
                continue;
            } else if(curr+ dice ==100) {
                System.out.println(pName +" has won the game.");
                return;
            } else {
                List<Snake> snakes = board.getSnakes();
                List<Ladder> ladders = board.getLadders();
                int newPos = curr+dice;
                Map<Integer, Integer> snakeSet = new HashMap<>();
                for(int i =0; i< snakes.size(); i++)
                    snakeSet.put(snakes.get(i).getStart(), snakes.get(i).getEnd());
                while(snakeSet.containsKey(newPos) ){
                    System.out.println("bit by snake at pos"+newPos);
                    newPos = snakeSet.get(newPos);
                }
                Map<Integer, Integer> ladderSet = new HashMap<>();
                for(int i =0; i< ladders.size(); i++)
                    ladderSet.put(ladders.get(i).getStart(), ladders.get(i).getEnd());
                while(ladderSet.containsKey(newPos)){
                    System.out.println("climb by ladder at pos"+newPos);
                    newPos = ladderSet.get(newPos);
                }
                position.put(turn,newPos);
            }
        }
        return ;
    }
}
