package com.company;

import java.net.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        int serverPort = 5555;
        String address = "127.0.0.1";

        try {
            InetAddress ipAddress = InetAddress.getByName(address);
            Socket socket = new Socket(ipAddress, serverPort);
            System.out.println("Connected to server. Game started!");

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);
            Game.Start(in, out);

        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}