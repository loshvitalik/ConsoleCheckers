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
            case "won":
                System.out.println("You won! Congratulations, " + Game.name + "!");
                break;
            case "lost":
                System.out.println("You lost. Try again!");
                break;
            default:
                System.out.println(message);
        }
    }

    static int[] ParseInput(String input) {
        if (input.length() != 4) return new int[]{-1, -1, -1, -1};
        int fromRow = ParseLetter(input.charAt(0));
        int fromCol = CheckDigit(input.charAt(1));
        int toRow = ParseLetter(input.charAt(2));
        int toCol = CheckDigit(input.charAt(3));
        return new int[]{fromRow, fromCol, toRow, toCol};
    }

    private static int ParseLetter(char letter) {
        switch (letter) {
            case 'a':
                return 7;
            case 'b':
                return 6;
            case 'c':
                return 5;
            case 'd':
                return 4;
            case 'e':
                return 3;
            case 'f':
                return 2;
            case 'g':
                return 1;
            case 'h':
                return 0;
            default:
                return -1;
        }
    }

    private static int CheckDigit(char digit) {
        int n = Character.getNumericValue(digit);
        return (n >= 1 && n <= 8) ? n - 1 : -1;
    }
}
