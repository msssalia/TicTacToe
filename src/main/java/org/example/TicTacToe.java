package org.example;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class TicTacToe {
    private char[][] ticTacToe;
    private final int size;

    private int countInARow;
    private int countInAColumn;
    private int countInADiagonal;
    private final int maxCount;
    private Scanner in = new Scanner(System.in);
    private int x;
    private int y;

    public TicTacToe() {
        this(3, 3);
    }

    public TicTacToe(int size, int maxCount) {
        this.size = size;
        this.maxCount = maxCount;
        initArray();
    }

    public void startGame() {
        gameBoard();
        while (true) {

            System.out.println("Ходят Крестики");
            setX();
            if (isWinner('X')) break;

            System.out.println("ходят Нолики");
            setY();
            if (isWinner('0')) break;
        }
    }

    ;

    private void gameBoard() {
        for (int i = 0; i < ticTacToe.length; i++) {
            for (int j = 0; j < ticTacToe.length; j++) {
                System.out.print(ticTacToe[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private void initArray() {
        ticTacToe = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                ticTacToe[i][j] = '.';
            }
        }
    }

    // задача координат для X
    private void setX() {
        System.out.println("Выберите строку");
        x = in.nextInt() - 1;
        System.out.println("Выберите столбец");
        y = in.nextInt() - 1;
        if (ticTacToe[x][y] == '0' || ticTacToe[x][y] == 'X') {
            System.out.println("поле уже занято, введите другие значения");
            setX();
        } else {
            ticTacToe[x][y] = 'X';
            gameBoard();
        }
    }


    // задача координат для 0
    private void setY() {
        System.out.println("Выберите строку");
        x = in.nextInt() - 1;
        System.out.println("Выберите столбец");
        y = in.nextInt() - 1;
        if (ticTacToe[x][y] == 'X' || ticTacToe[x][y] == '0') {
            System.out.println("поле уже занято, введите другие значения");
            setY();
        } else {
            ticTacToe[x][y] = '0';
            gameBoard();
        }
    }

    private boolean isWinner(char c) {
       /* if (((ticTacToe[0][0] == c) && (ticTacToe[0][1] == c) && (ticTacToe[0][2] == c)) ||     // горизонтальные случаи победы
                ((ticTacToe[1][0] == c) && (ticTacToe[1][1] == c) && (ticTacToe[1][2] == c)) || // горизонтальные случаи победы
                ((ticTacToe[2][0] == c) && (ticTacToe[2][1] == c) && (ticTacToe[2][2] == c)) || // горизонтальные случаи победы
                ((ticTacToe[0][0] == c) && (ticTacToe[1][0] == c) && (ticTacToe[2][0] == c)) || // вертикальные случаи победы
                ((ticTacToe[0][1] == c) && (ticTacToe[1][1] == c) && (ticTacToe[2][1] == c)) || // вертикальные случаи победы
                ((ticTacToe[0][2] == c) && (ticTacToe[1][2] == c) && (ticTacToe[2][2] == c)) || // вертикальные случаи победы
                ((ticTacToe[0][0] == c) && (ticTacToe[1][1] == c) && (ticTacToe[2][2] == c)) || // диагональные случаи победы
                ((ticTacToe[0][2] == c) && (ticTacToe[1][1] == c) && (ticTacToe[2][0] == c))) { // диагональные случаи победы
            System.out.println("Победили: " + c);
            return false;
        } else if ((ticTacToe[0][0] != '.') && (ticTacToe[0][1] != '.') && (ticTacToe[0][2] != '.') &&
                (ticTacToe[1][0] != '.') && (ticTacToe[1][1] != '.') && (ticTacToe[1][2] != '.') &&
                (ticTacToe[2][0] != '.') && (ticTacToe[2][1] != '.') && (ticTacToe[2][2] != '.')) {
            System.out.println("ничья");
            return false;
        }
        return true;
    }
*/
        /*
            {'.', '.', '.'},
            {'.', '.', '.'},
            {'.', '.', '.'}
         */
     /*  for (int i = 1; i < ticTacToe.length - 1; i++) {
            for (int j = 1; j < ticTacToe.length - 1; j++) {
                if (ticTacToe[i][j] == c && ticTacToe[i][j - 1] == c && ticTacToe[i][j + 1] == c) {
                    System.out.println("Победили: " + c);
                    return true;
                }
                else if (ticTacToe[i - 1][j - 1] == c && ticTacToe[i][j - 1] == c && ticTacToe[i + 1][j - 1] == c) {
                    System.out.println("Победили: " + c);
                    return true;
                } else if (ticTacToe[i][j] == c && ticTacToe[i - 1][j - 1] == c && ticTacToe[i + 1][j + 1] == c) {
                    System.out.println("Победили: " + c);
                    return true;
                }
                else if (ticTacToe[i - 1][j + 1] == c && ticTacToe[i][j] == c && ticTacToe[i + 1][j - 1] == c) {
                    System.out.println("Победили: " + c);
                    return true;
                }
            }

        }

       */
        for (int i = 0; i < ticTacToe.length; i++) {
            for (int j = 0; j < ticTacToe.length; j++) {
                if (ticTacToe[i][j] == ticTacToe[i][j + 1] && (j != ticTacToe.length - 1) && ticTacToe[i][j] == c) {
                    countInAColumn++;
                } else countInAColumn = 0;
                if (maxCount == countInAColumn) {
                    System.out.println("Победили: " + c);
                    return true;
                } else if (ticTacToe[i][j] == ticTacToe[i + 1][j] && (i != ticTacToe.length - 1) && ticTacToe[i][j] == c) {
                    countInARow++;
                } else countInARow = 0;
                if (maxCount == countInARow) {
                    System.out.println("Победили: " + c);
                    return true;
                } else if (ticTacToe[i][j] == ticTacToe[i + 1][j + 1] && ticTacToe[i][j] == c && (i != ticTacToe.length - 1) && (j != ticTacToe.length - 1)) {
                    countInADiagonal++;
                } else countInADiagonal = 0;
                if (maxCount == countInADiagonal) {
                    System.out.println("Победили: " + c);
                    return true;
                }

            }

        }

        return false;
    }
}

