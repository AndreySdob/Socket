package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args){
        try (Socket clientSocket = new Socket("localhost" , Server.PORT);
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            writer.println("Hello from Anya");
            System.out.println("Hello from Moscow" + " " + reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
