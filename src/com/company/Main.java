package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] string = scanner.nextLine().replaceAll("\\s*", "").split("");

        ArrayList<Token> tokens = TokenInitialization.divToken(string);

        System.out.println(Count.expr(tokens));
    }

}