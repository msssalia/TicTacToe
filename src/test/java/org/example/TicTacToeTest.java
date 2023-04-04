package org.example;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TicTacToeTest {
    private final static int ARRAY_SIZE = 15;

    @Test
    @Order(1)
    public void cyclesRows() {
        DemoWindow demoWindow = new DemoWindow(ARRAY_SIZE);
        char[][] board = createBoard(ARRAY_SIZE);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '*';
                demoWindow.setCurrentCell(board);
            }
        }
    }

    @Test
    @Order(2)
    public void cyclesColumns() {
        DemoWindow demoWindow = new DemoWindow(ARRAY_SIZE);
        char[][] board = createBoard(ARRAY_SIZE);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[j][i] = '*';
                demoWindow.setCurrentCell(board);
            }
        }
    }

    @Test
    @Order(3)
    public void cyclesDiagonalTopLeftBottomRight() {
        DemoWindow demoWindow = new DemoWindow(ARRAY_SIZE);
        char[][] board = createBoard(ARRAY_SIZE);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length - i; j++) {
                board[j + i][j] = '*';
                demoWindow.setCurrentCell(board);
            }
        }

        for (int i = 1; i < board.length; i++) {
            for (int j = 0; j < board.length - i; j++) {
                board[j][j + i] = '*';
                demoWindow.setCurrentCell(board);
            }
        }

    }

    @Test
    @Order(4)
    public void cyclesDiagonalBottomLeftTopRight() {
        DemoWindow demoWindow = new DemoWindow(ARRAY_SIZE);
        char[][] board = createBoard(ARRAY_SIZE);

        for (int k = 0; k < board.length; k++) {
            for (int i = (board.length - 1) - k, j = 0; i > -1 && j < board.length - k; i--, j++) {
                board[i][j] = '*';
                demoWindow.setCurrentCell(board);
            }
        }

        for (int k = 0; k < board.length - 1; k++) {
            for (int i = (board.length - 1), j = (1 + k); i > k && j < board.length; i--, j++) {
                board[i][j] = '*';
                demoWindow.setCurrentCell(board);
            }
        }

    }

    public static char[][] createBoard(int arraySize) {
        char[][] board = new char[arraySize][arraySize];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '.';
            }
        }
        return board;
    }

}
