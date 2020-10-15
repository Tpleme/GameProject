package org.acadmeiadecodigo.gnunas.keepitclean.characters;

import org.acadmeiadecodigo.gnunas.keepitclean.Directions;
import org.acadmeiadecodigo.gnunas.keepitclean.Position;

public abstract class Character {

    protected Position pos;
    public abstract void move(Directions direction);

    public Position getPos() {
        return pos;
    }
}
