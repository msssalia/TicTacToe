package org.example;

import javax.swing.*;
import java.awt.*;

public class DemoWindow extends JFrame {
    private static final int CELL_SIZE = 50;
    private final static int SLEEP_BETWEEN_ITERATION = 25;
    private Cell[][] cells;


    public DemoWindow(int arraySize) throws HeadlessException {
        setSize(arraySize * CELL_SIZE, arraySize * CELL_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout layout = new GridLayout(arraySize, arraySize);
        setLayout(layout);

        initCells(arraySize);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setCurrentCell(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '*') {
                    cells[i][j].setBackground(Color.BLUE);
                } else {
                    cells[i][j].setBackground(Color.WHITE);
                }
            }
        }
        try {
            Thread.sleep(SLEEP_BETWEEN_ITERATION);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    private void initCells(int arraySize) {
        cells = new Cell[arraySize][arraySize];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                Cell jCell = new Cell(i, j);
                cells[i][j] = jCell;
                add(jCell);
            }
        }
    }

    private static class Cell extends JPanel {

        public Cell(int x, int y) {
            setBackground(Color.WHITE);
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JLabel label = new JLabel(String.format("i:%s  j:%s", x, y));
            add(label);
        }

    }
}
//test