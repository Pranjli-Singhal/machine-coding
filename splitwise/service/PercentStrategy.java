package com.pranjli.machinecoding.splitwise.service;

import com.pranjli.machinecoding.splitwise.dao.InMemoryDAO;
import com.pranjli.machinecoding.splitwise.models.user;

import java.util.List;
import java.util.Map;

public class PercentStrategy implements SplitStrategy{
    InMemoryDAO inMemoryDAO = new InMemoryDAO();
    @Override
    public void split(List<String> payer, List<String> perOrAmt,Map<String, user> users, int payee,Double amt,double[][] account){
        int per=100;
        for(int i1 =0;i1< perOrAmt.size();i1++)
            per-=Double.parseDouble(perOrAmt.get(i1));
        if(per==0) {
            for(int i1 =0;i1< perOrAmt.size();i1++){
                String pay = payer.get(i1);
                int payId = users.get(pay).getId();
                if (payId != payee)
                    inMemoryDAO.updateBalance(payId, (Double.parseDouble(perOrAmt.get(i1))/100)*amt, payee, account);
            }
        }
    }
}
