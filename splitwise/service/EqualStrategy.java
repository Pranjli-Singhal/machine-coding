package com.pranjli.machinecoding.splitwise.service;

import com.pranjli.machinecoding.splitwise.dao.InMemoryDAO;
import com.pranjli.machinecoding.splitwise.models.user;

import java.util.List;
import java.util.Map;



public class EqualStrategy implements SplitStrategy{
InMemoryDAO inMemoryDAO = new InMemoryDAO();
    @Override
    public void split(List<String> payer,List<String> perOrAmt, Map<String, user> users, int payee,Double amt,double[][] account){

        for(String pay : payer){
            //can add user service to fetch user
            int payId = users.get(pay).getId();

            if(payId != payee)
                //TODO : CONVERT 33.33 TO 33.34 FOR FIRST PAYER
                inMemoryDAO.updateBalance(payId, amt/payer.size(), payee,account);
        }
    }
}
