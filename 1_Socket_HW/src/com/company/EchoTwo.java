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
            String outputLine;
            while ((inputLine = in.nextLine()) != null) {
                System.out.println(inputLine);
                if((outputLine = sc.nextLine()) != null)
                    out.println(outputLine);
            }
        }
    }

}