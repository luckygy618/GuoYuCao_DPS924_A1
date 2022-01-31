package com.guoyucao.calculator;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Calculator {
    protected int sum;
    protected String result;
    protected String errorMsg;
    protected ArrayList<String> list;
    protected HashSet<String> strSet;
    public Calculator(){
        sum=0;
        result="";
        errorMsg = "";
        list = new ArrayList<String>();
        strSet = new HashSet<String>();
         strSet.add("+");
        strSet.add("-");
        strSet.add("*");
        strSet.add("/");
        strSet.add("POW");
        strSet.add("MAX");
        strSet.add("MINI");
        strSet.add("%");


    }



    void push (String value){

        list.add(value);
    }


    void clear (){
        sum=0;
        result="";
        list.clear();
        errorMsg="";
    }
    int calculate(){
        int total = 0;
        if(list.size()<3){
            errorMsg = "Error: Not An Operator. "+"Please Enter at least 2 Numbers and one operator.";
            return -99999999;}
        if(strSet.contains(list.get(0))){
            errorMsg = "Error: Not An Operator. "+ "Please Enter Number First.";
            return -99999999;
        }
        if(strSet.contains(list.get(list.size()-1))){
            errorMsg = "Error: Not An Operator. "+"Please Enter Complete Number Operation.";
            return -99999999;
        }

        total = Integer.valueOf(list.get(0));
        int index = 2;
        while(list.size()>0&&index<list.size()){
            if(!strSet.contains(list.get(index))&&strSet.contains(list.get(index-1))){
                total = operatorCalculate( list.get(index-1), Integer.valueOf(list.get(index)), total);
                index +=2;
            }else{
                errorMsg = "Error: Not An Operator, returns -99999999";
                return -99999999;
            }

        }


        return total;
    }


    String getResult(){
       result = getInput();
        int last = this.calculate();
        if(errorMsg.length() >0){
            result +=  "= " + errorMsg;
        }else{
            result +=  "= " + String.valueOf(last);
        }
        return result;
    }

    String getInput(){
        String res = " ";
        for (String str : this.list) {
            res += str +" ";
        }
        return res;
    }

    int operatorCalculate(String o, int num,int sum){
        switch (o) {
            case "+":
                sum += num;
                break;
            case "-":
                sum -= num;
                break;
            case "*":
                sum *= num;
                break;
            case "POW":
                int res = (int)Math.pow(sum, num);
                sum = res;

                break;
            case "%":
                sum %= num;
                break;
            case "MAX":
                if (sum>=num){
                    sum = sum;
                }else{
                    sum = num;
                }
                break;
            case "MINI":
                if (sum<=num){
                    sum = sum;
                }else{
                    sum = num;
                }
                break;
            case "/":
                if(num!=0){
                    sum /= num;
                }else{
                    errorMsg = "Error: Cannot divide 0.";
                    sum = -99999999;
                }
                break;
            default:
                System.out.println("Looking forward to Calculate");
        }
        return sum;


    }

}
