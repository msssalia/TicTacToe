package org.example;

public class Game {
    private char[][] board;
    private final int size;

    private final int maxCount;

    private final Player player1;
    private final Player player2;


    public Game(int size, int maxCount, Player player1, Player player2) {
        this.size = size;
        this.maxCount = maxCount;
        this.player1 = player1;
        this.player2 = player2;
        initBoard();
    }

    public void startGame() {
        while (true) {

            while (!fillBoard(player1)) ;

            if (isWinner(player1.getaChar())) {
                renderBoard();
                System.out.println("Победили: " + player1.getaChar());
                break;
            }

            while (!fillBoard(player2)) ;

            if (isWinner(player2.getaChar())) {
                renderBoard();
                System.out.println("Победили: " + player2.getaChar());
                break;
            }

            if(isDraw() == true ) {
                renderBoard();
                System.out.println("Ничья!");
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

    private boolean fillBoard(Player player) {
        renderBoard();
        System.out.println("Ход: " + player.getaChar());

        Position position = player.getPosition();
        int x = position.getX();
        int y = position.getY();

        if (x < 0 || y < 0 || x > (size - 1) || y > (size - 1)) {
            System.out.println("Введите коректные данные");
            return false;
        }

        if (board[x][y] != '.') {
            System.out.println("Поле уже занято, введите другие значения");
            return false;
        }

        board[x][y] = player.getaChar();
        return true;
    }

    private boolean isWinner(char c) {
        if (isColumnOrRawWin(c) == true || isMainDiagonalWin(c) == true || isSecondaryDiagonalWin(c) == true) {
            return true;
        } else return false;

    }

    private boolean isColumnOrRawWin(char c) {
        for (int i = 0; i < board.length; i++) {

            int row = 0;
            int column = 0;


            for (int j = 0; j < board.length; j++) {

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

    private boolean isMainDiagonalWin(char c) { //ошибка при переходе на новую диагональ оставляет счетчик прежним
        int diagonal = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length - i; j++) {
                if (board[i + j][j] == c) {

                    diagonal++;
                } else {
                    diagonal = 0;
                }
                if (diagonal == maxCount) {
                    return true;
                }
            }
        }
        for (int i = 1; i < board.length; i++) {
            for (int j = 0; j < board.length - i; j++) {
                if (board[j][j + i] == c) {
                    diagonal++;
                } else {
                    diagonal = 0;
                }
                if (diagonal == maxCount) {
                    return true;
                }
            }

        }
        return false;
    }

    private boolean isSecondaryDiagonalWin(char c) { //ошибка при переходе на новую диагональ оставляет счетчик прежним
        int diagonal = 0;
        for (int k = 0; k < board.length; k++) {
            for (int i = (board.length - 1) - k, j = 0; i > -1 && j < board.length - k; i--, j++) {
                if (board[i][j] == c) {
                    diagonal++;
                } else {
                    diagonal = 0;
                }
                if (diagonal == maxCount) {
                    return true;
                }
            }
        }
        for (int k = 0; k < board.length - 1; k++) {
            for (int i = (board.length - 1), j = (1 + k); i > k && j < board.length; i--, j++) {
                if (board[i][j] == c) {
                    diagonal++;
                } else {
                    diagonal = 0;
                }
                if (diagonal == maxCount) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isDraw() {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    count++;
                } else count = 0;
            }
            if (count == size*size) {
                return true;
            }
        }
        return false;
    }
}
