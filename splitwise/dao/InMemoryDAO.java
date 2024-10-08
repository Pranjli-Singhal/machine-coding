package com.pranjli.machinecoding.splitwise.dao;

import com.pranjli.machinecoding.splitwise.enums.Expense;
import com.pranjli.machinecoding.splitwise.models.user;
import com.pranjli.machinecoding.splitwise.service.EqualStrategy;
import com.pranjli.machinecoding.splitwise.service.ExactStrategy;
import com.pranjli.machinecoding.splitwise.service.PercentStrategy;
import com.pranjli.machinecoding.splitwise.service.SplitStrategy;

import java.util.List;
import java.util.Map;

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

    public void split(SplitStrategy paymentStrategy,List<String> perOrAmt, List<String> payer, Map<String, user> users, int payee,Double amt,double[][] account){

        System.out.println(payer.size());
        paymentStrategy.split(payer,perOrAmt, users, payee,amt,account);
    }




}
