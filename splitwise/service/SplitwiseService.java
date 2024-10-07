package com.pranjli.machinecoding.splitwise.service;

import com.pranjli.machinecoding.splitwise.dao.InMemoryDAO;
import com.pranjli.machinecoding.splitwise.enums.Expense;
import com.pranjli.machinecoding.splitwise.models.user;

import java.text.DecimalFormat;
import java.util.*;

public class SplitwiseService {
    static double account[][] = new double[6][6];
    static Map<String, user> users = new HashMap<>();
    static Map<Integer, String> nameMapping = new HashMap<>();
    static InMemoryDAO inMemoryDAO = new InMemoryDAO();
    private static final DecimalFormat decfor = new DecimalFormat("0.00");

    public static void initialize(){
        users.put("user0",new user("user1","df@gdj.com",0,"930747"));
        users.put("user1",new user("user2", "fb@jfbg",1,"3943875"));
        users.put("user2",new user("user3", "ffdb@jfbg",2,"123943875"));
        users.put("user3",new user("user4", "fjhgb@jfbg",3,"3943875"));
        users.put("user4",new user("user5", "fbgfj@jfbg",4,"394387535"));
        users.put("user5",new user("user6", "aaffb@jfbg",5,"394384575"));
        nameMapping.put(1,"user1");
        nameMapping.put(2,"user2");
        nameMapping.put(3,"user3");
        nameMapping.put(4,"user4");
        nameMapping.put(5,"user5");
        nameMapping.put(0,"user0");

    }

    public static void drive(){

        Scanner scan = new Scanner(System.in);
        while(true){
        String inp = scan.nextLine();
        String inputs[] = inp.trim().split(" ");

        if(inputs.length ==1){
            showAll();
        } else{
            if(inputs[0].equals("SHOW")) {
                if (!show(inputs[1]))
                    System.out.println("No balances");
            }
            else{
                int n = inputs.length;
                int payee = users.get(inputs[1]).getId();
                Double amt = Double.parseDouble(inputs[2]);
                int count = Integer.parseInt(inputs[3]);
                List<String> payer = new ArrayList<>();
                int i =4;

                while(count-- > 0){
                    payer.add(inputs[i]);
                    i++;
                }
                String expense = inputs[i];
                i++;
                List<String> perOrAmt = new ArrayList<>();
                while(i < n){
                    perOrAmt.add(inputs[i]);
                    i++;
                }
                //can use strategy pattern here
                if(expense.equals(Expense.EQUAL.toString())){
                    for(String pay : payer){
                        //can add user service to fetch user from
                        int payId = users.get(pay).getId();
                        if(payId != payee)
                            //TODO : CONVERT 33.33 TO 33.34 FOR FIRST PAYER
                            //amt = Double.parseDouble(decfor.format(amt));
                            inMemoryDAO.updateBalance(payId, amt/payer.size(), payee,account);
                    }

                } else if(expense.equals(Expense.EXACT.toString())){
                    for(int i1 =0;i1< perOrAmt.size();i1++)
                        amt-=Double.parseDouble(perOrAmt.get(i1));
                    if(amt==0) {
                        for(int i1 =0;i1< perOrAmt.size();i1++){
                            String pay = payer.get(i1);
                            int payId = users.get(pay).getId();
                            if (payId != payee)
                                inMemoryDAO.updateBalance(payId, Double.parseDouble(perOrAmt.get(i1)), payee, account);
                        }
                    }
                } else {
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
        }}
    }

    public static void showAll(){
        boolean ans = false;
        for(Map.Entry<String, user> entry: users.entrySet())
            ans = ans || show(entry.getKey());
        if(!ans){
            System.out.println("No balances");
        }
    }

    public static boolean show(String userId){
        boolean exist = false;
        int id = users.get(userId).getId();
        for(int i =0; i<account.length;i++ ){
            if(account[id][i] !=0){
                exist = true;
                System.out.println(userId+" owes "+nameMapping.get(i)+": "+ account[id][i]);
            }
            if(account[i][id] !=0){
                exist = true;
                System.out.println(nameMapping.get(i)+" owes "+userId+": "+ account[i][id]);

            }
        }
        return exist;
    }

}
