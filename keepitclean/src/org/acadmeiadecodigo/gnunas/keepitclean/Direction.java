package org.acadmeiadecodigo.gnunas.keepitclean;

public enum Direction {
    UP,
    DOWN,
    RIGHT,
    LEFT,
    DIAGONAL_DOWN_LEFT,
    DIAGONAL_DOWN_RIGHT,
    DIAGONAL_UP_LEFT,
    DIAGONAL_UP_RIGHT,
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
            case DIAGONAL_DOWN_LEFT:
                oppositeDirection=Direction.DIAGONAL_UP_RIGHT;
                break;
            case DIAGONAL_DOWN_RIGHT:
                oppositeDirection= Direction.DIAGONAL_UP_LEFT;
                break;
            case DIAGONAL_UP_LEFT:
                oppositeDirection=Direction.DIAGONAL_DOWN_RIGHT;
                break;
            case DIAGONAL_UP_RIGHT:
                oppositeDirection=Direction.DIAGONAL_DOWN_LEFT;
                break;


        }

        return oppositeDirection;
    }
}
