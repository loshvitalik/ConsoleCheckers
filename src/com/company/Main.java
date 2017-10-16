package com.company;

import java.net.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Checkers (c) loshvitalik & MrBlacktop, 2017");

        String address = "127.0.0.1";
        int serverPort = 5555;

        try {
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String input;
            System.out.println("Server IP: (leave blank for default)");
            input = keyboard.readLine();
            if (!(input.equals(""))) address = input;
            System.out.println("Server port: (leave blank for default)");
            input = keyboard.readLine();
            if (!(input.equals(""))) serverPort = Integer.parseInt(input);

            InetAddress ipAddress = InetAddress.getByName(address);
            Game.Start(ipAddress, serverPort);

        } catch (Exception x) {
            System.out.println("Connection error. Try restarting the game");
        }
    }
}