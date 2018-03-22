package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TicTacToeLogic logic = new TicTacToeLogic();
        logic.printBoard();
        System.out.println("Grasz jako x");

        while (!logic.isFinished()) {
            Scanner in = new Scanner(System.in);
            System.out.println("Podaj wiersz i kolumne:");
            int row = in.nextInt() - 1;
            int column = in.nextInt() - 1;
            logic.move("x", row, column);
            logic.printBoard();
            if (logic.isFinished() == true)
                break;
            System.out.println("Ruch komputera:");
            logic.moveRandom("o");
            logic.printBoard();
        }

        // write your code here
    }
}
