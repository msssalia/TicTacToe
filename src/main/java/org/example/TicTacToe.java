package org.example;

public class TicTacToe {
    private char[][] board;
    private final int size;

    private final int maxCount;
    private int x;
    private int y;

    private final Player player1;
    private final Player player2;

    public TicTacToe(Player player1, Player player2) {
        this(3, 3, player1, player2);
    }

    public TicTacToe(int size, Player player1, Player player2) {
        this(size, 3, player1, player2);
    }

    public TicTacToe(int size, int maxCount, Player player1, Player player2) {
        this.size = size;
        this.maxCount = maxCount;
        this.player1 = player1;
        this.player2 = player2;
        initBoard();
    }

    public void startGame() {
        renderBoard();
        while (true) {

            fillBoard(player1);
            if (isWinner(player1.getaChar())) {
                System.out.println("Победили: " + player1.getaChar());
                break;
            }

            fillBoard(player2);
            if (isWinner(player2.getaChar())) {
                System.out.println("Победили: " + player2.getaChar());
                break;
            }
        }
    }

    private void renderBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private void initBoard() {
        board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '.';
            }
        }
    }

    private void fillBoard(Player player) {
        System.out.println("Ход: " + player.getaChar());

        Position position = player.getPosition();
        int x = position.getX();
        int y = position.getY();

        if (x < 0 || y < 0 || x > (size - 1) || y > (size - 1)){
            System.out.println("Введите коректные данные");
            fillBoard(player);
        }

        if (board[x][y] != '.'){
            System.out.println("Поле уже занято, введите другие значения");
            fillBoard(player);
        }

        board[x][y] = player.getaChar();
    }

    private boolean isWinner(char c) {
        for (int i = 0; i < board.length; i++) {

            int row = 0;
            int column = 0;

            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] == c) {
                    row++;
                } else {
                    row = 0;
                }

                if (row == maxCount) {
                    return true;
                }

                if (board[j][i] == c) {
                    column++;
                } else {
                    column = 0;
                }

                if (column == maxCount) {
                    return true;
                }
            }
        }

        return false;
    }
}

