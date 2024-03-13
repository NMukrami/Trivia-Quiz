package com.nukmancode;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        playGame();


    }
    private static void playGame() {
        var score = 0;
        var questionNumber = 1;
        var questionAmount = amountQuestion();
        System.out.println();
        var questions = getQuestion(questionAmount);
        System.out.println(questions);



    }


    private static String getQuestion(int questionAmount) {
        var url = "https://opentdb.com/api.php?amount=" + questionAmount + "&category=18&type=multiple";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    private static int amountQuestion() {
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
