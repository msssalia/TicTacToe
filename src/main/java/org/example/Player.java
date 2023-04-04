package org.example;

public abstract class Player {

    private final char aChar;

    public Player(char aChar) {
        this.aChar = aChar;
    }

    public char getaChar() {
        return aChar;
    }

    public abstract Position getPosition();
}
