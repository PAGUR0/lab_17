package com.company;

import java.util.ArrayList;

public class Count {

    static ArrayList<Token> tokens;
    static int i;

    static double expr(ArrayList<Token> token){
        tokens = token;
        i = 0;
        return addsub();
    }

    static double addsub(){
        double value_1 = muldiv();
        while (tokens.get(i+1).getType().equals("+") || tokens.get(i+1).getType().equals("-")){
            i++;
            i++;
            int buffer = i;
            double value_2 = muldiv();
            switch (tokens.get(buffer-1).getType()){
                case ("+") -> {
                    value_1 += value_2;
                }
                case ("-") -> {
                    value_1 -= value_2;
                }
            }
        }
        return value_1;
    }

    static double muldiv(){
        double value_1 = factor();
        while (tokens.get(i+1).getType().equals("*") || tokens.get(i+1).getType().equals("/")){
            i++;
            i++;
            int buffer = i;
            double value_2 = factor();
            switch (tokens.get(buffer-1).getType()){
                case ("*") -> value_1 *= value_2;
                case ("/") -> value_1 /= value_2;
            }
        }
        return value_1;
    }

    static double factor(){
        if(tokens.get(i).getType().equals("num")){
            return Double.parseDouble(tokens.get(i).getValue());
        }
        else if(tokens.get(i).getType().equals("(")){
            i++;
            double result = addsub();
            i++;
            return result;
        }
        return -1;
    }
}
