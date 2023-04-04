package org.example;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TicTacToeTest {
    private final static int SIZE = 10;
    private final static int SLEEP = 50;

    @Test
    @Order(1)
    public void cyclesRows() {
        DemoWindow demoWindow = new DemoWindow(SIZE, SLEEP);
        char[][] board = createBoard(SIZE);

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board.length; j++) {

                board[i][j] = '*';
                demoWindow.setCurrentCell(board);
                demoWindow.fillLabels(board);
            }
        }
    }

    @Test
    @Order(2)
    public void cyclesColumns() {
        DemoWindow demoWindow = new DemoWindow(SIZE, SLEEP);
        char[][] board = createBoard(SIZE);

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board.length; j++) {

                board[j][i] = '*';
                demoWindow.setCurrentCell(board);
                demoWindow.fillLabels(board);
            }
        }
    }

    @Test
    @Order(3)
    public void cyclesDiagonalTopLeftBottomRight() {
        DemoWindow demoWindow = new DemoWindow(SIZE, SLEEP);
        char[][] board = createBoard(SIZE);

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board.length - i; j++) {

                board[j + i][j] = '*';
                demoWindow.setCurrentCell(board);
                demoWindow.fillLabels(board);
            }
        }

        for (int i = 1; i < board.length; i++) {

            for (int j = 0; j < board.length - i; j++) {

                board[j][j + i] = '*';
                demoWindow.setCurrentCell(board);
                demoWindow.fillLabels(board);
            }
        }

    }

    @Test
    @Order(4)
    public void cyclesDiagonalBottomLeftTopRight() {
        DemoWindow demoWindow = new DemoWindow(SIZE, SLEEP);
        char[][] board = createBoard(SIZE);

        for (int k = 0; k < board.length; k++) {

            for (int i = (board.length - 1) - k, j = 0; i > -1 && j < board.length - k; i--, j++) {

                board[i][j] = '*';
                demoWindow.setCurrentCell(board);
                demoWindow.fillLabels(board);
            }
        }

        for (int k = 0; k < board.length - 1; k++) {

            for (int i = (board.length - 1), j = (1 + k); i > k && j < board.length; i--, j++) {

                board[i][j] = '*';
                demoWindow.setCurrentCell(board);
                demoWindow.fillLabels(board);
            }
        }

    }

    public static char[][] createBoard(int size) {
        char[][] board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '.';
            }
        }
        return board;
    }

}
