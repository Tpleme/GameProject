package org.acadmeiadecodigo.gnunas.keepitclean;

public enum Direction {
    UP,
    DOWN,
    RIGHT,
    LEFT,
    NONE;

    public Direction opposite(){

        Direction oppositeDirection = Direction.NONE;
        
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
