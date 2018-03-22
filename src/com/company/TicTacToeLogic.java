package com.company;

import java.util.Objects;
import java.util.Random;

/**
 * Created by RadekE730 on 2018-03-08.
 */
public class TicTacToeLogic {


    Random gen = new Random();

    private final int SIZE = 3;
    private final String x = "x";
    private final String o = "o";

    private String[][] board;

    public TicTacToeLogic() {
        init();
    }

    private void init() {
        board = new String[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = "-";
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


    public boolean move(String symbol, int rowIndex, int columnIndex) {
        if ((symbol.equals(x)) || (symbol.equals(o))) {
            if (board[rowIndex][columnIndex] == "-") {
                board[rowIndex][columnIndex] = symbol;
                return true;
            } else {
                System.out.println("zmien pole");
                return false;
            }
        } else {
            System.out.println("wpisz 'x' lub i 'o', a nie brzydkie rzeczy");
            return false;
        }
    }

    public void moveRandom(String symbol) {
        int a = 1;
        do {
            int rowIndex = gen.nextInt(3);
            int columnIndex = gen.nextInt(3);
            if (board[rowIndex][columnIndex] == "-") {
                board[rowIndex][columnIndex] = symbol;
                a = 0;
            }
        } while (a == 1);
    }

    public boolean isFinished() {


        if ((Objects.equals(board[0][0], board[1][1])) && (Objects.equals(board[1][1], board[2][2]))) {
            if (!Objects.equals(board[0][0], "-")) {
                String a = board[0][0];
                System.out.println("wygrana " + a);
                return true;
            }
        }
        if ((Objects.equals(board[0][2], board[1][1])) && (Objects.equals(board[1][1], board[2][0]))) {
            if (board[0][2] != "-") {
                String a = board[0][2];
                System.out.println("wygrana " + a);
                return true;
            }
        }


        for (int i = 0; i < SIZE; i++) {

            if (Objects.equals(board[i][0], board[i][1]) && Objects.equals(board[i][1], board[i][2])) {
                if (board[i][0] != "-") {
                    String a = board[i][0];
                    System.out.println("wygrana " + a);
                    return true;
                }

            } else if (Objects.equals(board[0][i], board[1][i]) && Objects.equals(board[1][i], board[2][i])) {
                if (board[0][i] != "-") {
                    String a = board[0][i];
                    System.out.println("wygrana " + a);
                    return true;
                }
            }
        }
        int licznik = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == "-") {
                    licznik++;
                }
            }
        }
        
        if (licznik == 0) {
            System.out.println("koniec gry");
            return true;
        }
        return false;
    }
}
