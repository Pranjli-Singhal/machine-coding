package com.pranjli.machinecoding.snakeandladder.util;

import java.util.Random;

public class DiceUtil{
    //support multiple dice
    public static int throwDice(int numDice){
        int num =0;
        while(numDice > 0){
            num += new Random().nextInt(6) ;
            num+=1;
            numDice--;
        }
        return num;
    }
}