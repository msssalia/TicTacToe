package org.example;

public class Robot extends Player {
    private final int size;

    public Robot(int size, char aChar) {
        super(aChar);
        this.size = size;
    }

    @Override
    public Position getPosition() {
        int x = (int) (Math.random() * size);
        int y = (int) (Math.random() * size);
        return new Position(x, y);
    }
}
