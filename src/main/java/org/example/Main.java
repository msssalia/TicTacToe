package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность поля NxN: ");
        int size = scanner.nextInt();
        System.out.println("Введите количество повторений в ряд для победы: ");
        int maxCount = scanner.nextInt();


        User user1 = new User('0');
        User user2 = new User('X');
        Robot robot = new Robot(size, 'D');

        System.out.println("Для игры вдвоем введите 2 ");
        System.out.println("Дл игры против компьютера введите 1");
        short gameMode = scanner.nextShort();
        if (gameMode == 1) {
            Game game = new Game(size, maxCount, user1, robot);
            game.startGame();
        } else if (gameMode == 2) {
            Game game = new Game(size, maxCount, user1, user2);
            game.startGame();
        }
    }


}