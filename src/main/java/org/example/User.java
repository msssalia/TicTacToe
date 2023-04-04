package org.example;

import java.util.Scanner;

public class User extends Player {

    private final Scanner scanner;

    public User(char aChar) {
        super(aChar);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Position getPosition() {

        System.out.println("Выберите строку");
        int x = getNextInt();

        System.out.println("Выберите столбец");
        int y = getNextInt();

        return new Position(x, y);
    }

    private int getNextInt() {
        String next = scanner.next();

        try {
            return Integer.parseInt(next);
        } catch (Exception e) {
            System.out.println("Ошибка ввода");
        }
        System.out.println("Еще разок...");
        return getNextInt();
    }
}
