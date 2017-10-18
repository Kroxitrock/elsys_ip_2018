package com.company;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoTwo {
    public static final int PORT = 31111;

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT);
             Socket clientSocket = serverSocket.accept();
                PrintStream out = new PrintStream(clientSocket.getOutputStream());
                Scanner sc = new Scanner(System.in);
                Scanner in = new Scanner(clientSocket.getInputStream())) {
                String inputLine;
                final String[] userInput = new String[1];

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while((userInput[0] = sc.nextLine()) != null) {
                            out.println(userInput[0]);
                        }
                    }
                }).start();

                while ((inputLine = in.nextLine()) != null) {
                    System.out.println(inputLine);
                }

        }
    }

}