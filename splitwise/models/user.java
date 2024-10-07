package com.pranjli.machinecoding.splitwise.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//open-closed principle
public class user {
    String name;
    Integer id;
    String email;
    String mobile;
    Map<String, Map<String,Double>> balances;
    Map<String, List<String>> own;

    //how to pass default values
    public user(String name, String email, Integer id, String mobile){
        this.name = name;
        this.email = email;
        this.id = id;
        this.mobile = mobile;
        this.balances =  new HashMap<>();

        this.own = new HashMap<>();

    }

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public Integer getId() {
    return id;
}

    public Map<String, List<String>> getOwn() {
        return own;
    }

    public void setId(Integer id) {
    this.id = id;
}

public String getEmail() {
    return email;
}

    public Map<String, Map<String, Double>> getBalances() {
        return balances;
    }

    public void setEmail(String email) {
    this.email = email;
}

public String getMobile() {
    return mobile;
}

public void setMobile(String mobile) {
    this.mobile = mobile;
}
}
