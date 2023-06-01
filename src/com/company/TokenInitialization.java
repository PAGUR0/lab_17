package com.company;

import java.util.ArrayList;

public class TokenInitialization {

    static public ArrayList<Token> divToken(String[] string){
        ArrayList<Token> tokens = new ArrayList<>();
        int i = 0;

        while (i < string.length){
            if ("(".equals(string[i])) {
                tokens.add(new Token("(", "("));
                i++;
            } else if (")".equals(string[i])) {
                tokens.add(new Token(")", ")"));
                i++;
            } else if ("+".equals(string[i])) {
                tokens.add(new Token("+", "+"));
                i++;
            } else if ("-".equals(string[i])) {
                tokens.add(new Token("-", "-"));
                i++;
            } else if ("*".equals(string[i])) {
                tokens.add(new Token("*", "*"));
                i++;
            } else if ("/".equals(string[i])) {
                tokens.add(new Token("/", "/"));
                i++;
            } else if (string[i].matches("\\d")) {
                StringBuilder num = new StringBuilder();
                do {
                    num.append(string[i]);
                    i++;
                    if (i >= string.length) {
                        break;
                    }
                } while (string[i].matches("\\d"));
                tokens.add(new Token(num.toString(), "num"));
            }
        }
        tokens.add(new Token(" ", "end"));
        return tokens;
    }
}