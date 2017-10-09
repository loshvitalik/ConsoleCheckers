package com.company;

public class FieldParser {
    public static int ParseInput(String input) {
        int fromRow = ParseLetter(input.charAt(0)) - 1;
        int fromCol = input.charAt(1) - 1;
        int toRow = ParseLetter(input.charAt(2)) - 1;
        int toCol = input.charAt(3) - 1;
        return fromRow * 1000 + fromCol * 100 + toRow * 10 + toCol;
    }

    public static int ParseLetter(char letter) {
        switch (letter) {
            case 'a':
                return 1;
            case 'b':
                return 2;
            case 'c':
                return 3;
            case 'd':
                return 4;
            case 'e':
                return 5;
            case 'f':
                return 6;
            case 'g':
                return 7;
            case 'h':
                return 8;
            default:
                return -1;
        }
    }
}
