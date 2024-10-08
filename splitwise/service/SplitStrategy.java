package com.pranjli.machinecoding.splitwise.service;

import com.pranjli.machinecoding.splitwise.models.user;

import java.util.List;
import java.util.Map;

public interface SplitStrategy {

    public void split(List<String> payer, List<String> perOrAmt,Map<String, user> users, int payee,Double amt,double[][] account);
}
