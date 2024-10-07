package com.pranjli.machinecoding.splitwise.dao;

import static java.lang.Math.round;

public class InMemoryDAO {

    public void updateBalance(int payId, double amt, int payee,double[][] account){

        if(account[payee][payId] > amt){

            account[payee][payId]-=amt;}
        else{
            double temp =account[payee][payId];
            account[payee][payId] =0;
            account[payId][payee]+=(amt-temp);
        }

    }




}
