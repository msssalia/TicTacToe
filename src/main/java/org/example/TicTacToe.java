package org.example;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class TicTacToe {
    private char[][] ticTacToe = {
            {'.', '.', '.'},
            {'.', '.', '.'},
            {'.', '.', '.'}
    };
    private Scanner in = new Scanner(System.in);
    private int x;
    private int y;


    public void startGame() {
        gameBoard();
        while (true) {

            System.out.println("Ходят Крестики");
            setX();
            if (!winner('X')) break;

            System.out.println("ходят Нолики");
            setY();
            if (!winner('0')) break;
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

    private boolean winner(char c) {
        if (((ticTacToe[0][0] == 'X') && (ticTacToe[0][1] == 'X') && (ticTacToe[0][2] == 'X')) ||     // горизонтальные случаи победы
                ((ticTacToe[1][0] == 'X') && (ticTacToe[1][1] == 'X') && (ticTacToe[1][2] == 'X')) || // горизонтальные случаи победы
                ((ticTacToe[2][0] == 'X') && (ticTacToe[2][1] == 'X') && (ticTacToe[2][2] == 'X')) || // горизонтальные случаи победы
                ((ticTacToe[0][0] == 'X') && (ticTacToe[1][0] == 'X') && (ticTacToe[2][0] == 'X')) || // вертикальные случаи победы
                ((ticTacToe[0][1] == 'X') && (ticTacToe[1][1] == 'X') && (ticTacToe[2][1] == 'X')) || // вертикальные случаи победы
                ((ticTacToe[0][2] == 'X') && (ticTacToe[1][2] == 'X') && (ticTacToe[2][2] == 'X')) || // вертикальные случаи победы
                ((ticTacToe[0][0] == 'X') && (ticTacToe[1][1] == 'X') && (ticTacToe[2][2] == 'X')) || // диагональные случаи победы
                ((ticTacToe[0][2] == 'X') && (ticTacToe[1][1] == 'X') && (ticTacToe[2][0] == 'X'))) { // диагональные случаи победы
            System.out.println("победили Крестики");
            return false;
        } else if (((ticTacToe[0][0] == '0') && (ticTacToe[0][1] == '0') && (ticTacToe[0][2] == '0')) ||     // горизонтальные случаи победы
                ((ticTacToe[1][0] == '0') && (ticTacToe[1][1] == '0') && (ticTacToe[1][2] == '0')) || // горизонтальные случаи победы
                ((ticTacToe[2][0] == '0') && (ticTacToe[2][1] == '0') && (ticTacToe[2][2] == '0')) || // горизонтальные случаи победы
                ((ticTacToe[0][0] == '0') && (ticTacToe[1][0] == '0') && (ticTacToe[2][0] == '0')) || // вертикальные случаи победы
                ((ticTacToe[0][1] == '0') && (ticTacToe[1][1] == '0') && (ticTacToe[2][1] == '0')) || // вертикальные случаи победы
                ((ticTacToe[0][2] == '0') && (ticTacToe[1][2] == '0') && (ticTacToe[2][2] == '0')) || // вертикальные случаи победы
                ((ticTacToe[0][0] == '0') && (ticTacToe[1][1] == '0') && (ticTacToe[2][2] == '0')) || // диагональные случаи победы
                ((ticTacToe[0][2] == '0') && (ticTacToe[1][1] == '0') && (ticTacToe[2][0] == '0'))) { // диагональные случаи победы
            System.out.println("победили Нолики");

            return false;
        } else if ((ticTacToe[0][0] != '.') && (ticTacToe[0][1] != '.') && (ticTacToe[0][2] != '.') &&
                (ticTacToe[1][0] != '.') && (ticTacToe[1][1] != '.') && (ticTacToe[1][2] != '.') &&
                (ticTacToe[2][0] != '.') && (ticTacToe[2][1] != '.') && (ticTacToe[2][2] != '.')) {
            System.out.println("ничья");
            return false;
        }
        return true;
    }



}