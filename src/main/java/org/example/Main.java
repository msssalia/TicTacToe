package org.example;

public class Main {
    public static void main(String[] args) {
        User user1 = new User('0');
        User user2 = new User('X');
        Game game = new Game(3, 2, user1, user2);
        game.startGame();
    }

}