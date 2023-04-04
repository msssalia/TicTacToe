package org.example;

import javax.swing.*;
import java.awt.*;

public class DemoWindow extends JFrame {

    private Cell[][] cells;
    private final int sleep;

    public DemoWindow(int size, int sleep) throws HeadlessException {
        this.sleep = sleep;

        setSize(size * 100, size * 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout layout = new GridLayout(size, size);
        setLayout(layout);

        initCells(size);

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
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clear() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                Cell cell = cells[i][j];
                cell.setBackground(Color.WHITE);
            }
        }
    }

    public void fillLabels(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '*') cells[i][j].getLabel().setText("*");
            }
        }
    }

    private void initCells(int size) {
        cells = new Cell[size][size];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                Cell jCell = new Cell(i, j);
                cells[i][j] = jCell;
                add(jCell);
            }
        }
    }

    private static class Cell extends JPanel {
        private final JLabel label;

        public Cell(int x, int y) {
            setBackground(Color.WHITE);
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
            label = new JLabel(String.format("i:%s  j:%s", x, y));
            add(label);
        }

        public JLabel getLabel() {
            return label;
        }
    }
}
