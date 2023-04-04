package org.example;

public class Main {
    public static void main(String[] args) {
        User user1 = new User('0');
        User user2 = new User('X');
        TicTacToe ticTacToe = new TicTacToe(8, 4, user1, user2);
        ticTacToe.startGame();
    }

}