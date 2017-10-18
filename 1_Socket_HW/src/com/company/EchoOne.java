package com.company;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoOne {
    private static final String HOST_NAME = "localhost";
    private static final int PORT = 31111;
    public static void main(String[] args) throws IOException {
        try (Socket echoSocket = new Socket(HOST_NAME, PORT);
             // get the output stream of the socket. We are sending this
             PrintStream out = new PrintStream(echoSocket
                     .getOutputStream());
             // get info from server here
             Scanner in = new Scanner(echoSocket.getInputStream());
             // keyboard input
             Scanner stdIn = new Scanner(System.in)) {
            final String[] userInput = new String[1];
            String inputLine;

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while((userInput[0] = stdIn.nextLine()) != null) {
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
