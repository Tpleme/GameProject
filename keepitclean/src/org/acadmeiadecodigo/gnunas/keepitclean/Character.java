package org.acadmeiadecodigo.gnunas.keepitclean;

public abstract class Character {

    private Position pos;
    public abstract void move();

    public Position getPos() {
        return pos;
    }
}
