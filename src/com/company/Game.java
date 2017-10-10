package com.company;

import java.io.*;

import com.google.gson.*;

public class Game {
    public static void Start(DataInputStream in, DataOutputStream out) {
        Gson gson = new Gson();
        int[][] board;
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String response;
        String input;
        while (true) {
            try {
                response = in.readUTF();
                board = gson.fromJson(response, int[][].class);
                char rowName = 'A';
                for (int i = 0; i < 8; i++) {
                    System.out.print(rowName++ + " ");
                    for (int j = -1; j < 8; j++)
                        if (j == -1)
                            System.out.print((j + 1) + " ");
                        else
                            switch (board[i][j]) {
                                case 0:
                                    System.out.print("  ");
                                case 1:
                                    System.out.print("w ");
                                case -1:
                                    System.out.print("b ");
                                case 2:
                                    System.out.print("W ");
                                case -2:
                                    System.out.print("B ");
                            }
                    System.out.println("");
                }
                System.out.println("Enter your turn with 'from' and 'to', like a2c3");
                input = keyboard.readLine();
                int[] turn = (input.length() == 4) ? FieldParser.ParseInput(input) : new int[]{-1, -1, -1, -1};
                out.writeUTF(gson.toJson(turn));
                out.flush();
                System.out.println("Waiting for your opponent's turn");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
