package com.company;

public class FieldParser {
    public static int[] ParseInput(String input) {
        int fromRow = ParseLetter(input.charAt(0));
        int fromCol = CheckDigit(input.charAt(1));
        int toRow = ParseLetter(input.charAt(2));
        int toCol = CheckDigit(input.charAt(3));
        return new int[]{fromRow, fromCol, toRow, toCol};
    }

    public static int ParseLetter(char letter) {
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

    public static int CheckDigit(char digit) {
        return (digit >= 1 && digit <= 8) ? digit - 1 : -1;
    }
}
