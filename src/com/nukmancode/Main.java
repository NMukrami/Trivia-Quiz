package com.nukmancode;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        playGame();


    }
    private static void playGame() {
        var score = 0;
        var questionNumber = 1;
        var questionAmount = amount_question();
        System.out.println(questionAmount);
    }

    private static int amount_question() {
        while(true) {
            try {
                System.out.print("How many question do you want (1-50): ");
                Scanner scanner = new Scanner(System.in);
                var amount =  scanner.nextInt();
                if (1 <= amount && amount <= 50) {
                    return amount;
                } else {
                    System.out.println("Number between 1 and 50");
                }
            } catch (Exception e) {
                System.out.println("Not a valid number. Please try again");
            }
        }
    }



}
