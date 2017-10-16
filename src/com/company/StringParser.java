package com.company;

class StringParser {

    static void ParseMessage(String message) {
        switch (message) {
            case "white_turn":
                Game.yourTurn = true;
                System.out.println("You're playing white. It's your turn. Enter your move, example: a1b2");
                break;
            case "black_turn":
                Game.yourTurn = true;
                System.out.println("You're playing black. It's your turn. Enter your move, example: a1b2");
                break;
            case "wait":
                System.out.println("Waiting for your opponent's turn");
                break;
            case "whites_won":
                System.out.println("Whites won. Congratulations!");
                break;
            case "blacks_won":
                System.out.println("Blacks won. Congratulations!");
                break;
            default:
                System.out.println(message);
        }
    }

    static int[] ParseInput(String input) {
        if (input.length() != 4) return new int[]{-1, -1, -1, -1};
        int fromCol = ParseLetter(input.charAt(0));
        int fromRow = CheckDigit(input.charAt(1));
        int toCol = ParseLetter(input.charAt(2));
        int toRow = CheckDigit(input.charAt(3));
        return new int[]{fromRow, fromCol, toRow, toCol};
    }

    private static int ParseLetter(char letter) {
        switch (letter) {
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;
            case 'e':
                return 4;
            case 'f':
                return 5;
            case 'g':
                return 6;
            case 'h':
                return 7;
            default:
                return -1;
        }
    }

    private static int CheckDigit(char digit) {
        int n = Character.getNumericValue(digit);
        return (n >= 1 && n <= 8) ? 8 - n : -1;
    }
}
