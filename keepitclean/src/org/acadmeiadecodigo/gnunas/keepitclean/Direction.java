package org.acadmeiadecodigo.gnunas.keepitclean;

public enum Direction {
    UP,
    DOWN,
    RIGHT,
    LEFT,
    /*DIAGONAL_DOWN_LEFT,
    DIAGONAL_DOWN_RIGHT,
    DIAGONAL_UP_LEFT,
    DIAGONAL_UP_RIGHT,*/
    SIT;

    public Direction opposite(){

        Direction oppositeDirection = Direction.SIT;

        switch (this){

            case UP:
                oppositeDirection=Direction.DOWN;
                break;
            case DOWN:
                oppositeDirection= Direction.UP;
                break;
            case LEFT:
                oppositeDirection=Direction.RIGHT;
                break;
            case RIGHT:
                oppositeDirection=Direction.LEFT;
                break;

        }

        return oppositeDirection;
    }
}
