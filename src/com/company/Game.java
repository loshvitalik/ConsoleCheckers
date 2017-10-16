package com.company;

import java.io.*;

import com.google.gson.*;

class Game {
    private static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    private static Gson gson = new Gson();
    private static int[][] board;
    static boolean yourTurn;
    static String name;

    static void Start(DataInputStream in, DataOutputStream out) {
        String response;
        String input;
        try {
            System.out.println("Choose your username:");
            name = keyboard.readLine();
            out.writeUTF(gson.toJson(name));
            System.out.println("Create your password:");
            input = keyboard.readLine();
            out.writeUTF(gson.toJson(input));
            out.flush();
            System.out.println("Welcome, " + name + "!");

            while (true) {
                board = gson.fromJson(in.readUTF(), int[][].class);
                DrawBoard();
                response = in.readUTF();
                StringParser.ParseMessage(gson.fromJson(response, String.class));
                if (response.equals("won") || response.equals("lost")) break;
                if (yourTurn) {
                    input = keyboard.readLine();
                    int[] turn = StringParser.ParseInput(input);
                    out.writeUTF(gson.toJson(turn));
                    out.flush();
                    yourTurn = false;
                }
            }
        } catch (IOException x) {
            System.out.println("Connection error. Try restarting the game");
        }
    }

    private static void DrawBoard() {
        PrintHeader();
        System.out.println("   -----------------   ");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " | ");
            for (int j = 0; j < 8; j++)
                switch (board[i][j]) {
                    case 0:
                        System.out.print(". ");
                        break;
                    case 1:
                        System.out.print("w ");
                        break;
                    case -1:
                        System.out.print("b ");
                        break;
                    case 2:
                        System.out.print("W ");
                        break;
                    case -2:
                        System.out.print("B ");
                        break;
                }
            System.out.print("| " + (8 - i));
            System.out.println("");
        }
        System.out.println("   -----------------   ");
        PrintHeader();
        System.out.println("");
    }

    private static void PrintHeader() {
        char colName = 'a';
        for (int i = 0; i <= 8; i++)
            if (i == 0)
                System.out.print("    ");
            else
                System.out.print(colName++ + " ");
            System.out.println();
    }
}
