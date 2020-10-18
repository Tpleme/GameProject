package org.acadmeiadecodigo.gnunas.keepitclean.characters;

import org.acadmeiadecodigo.gnunas.keepitclean.Direction;
import org.acadmeiadecodigo.gnunas.keepitclean.Position;

public abstract class Character {

    protected Position pos;
    public abstract void move(Direction direction);

    public Position getPos() {
        return pos;
    }
}
