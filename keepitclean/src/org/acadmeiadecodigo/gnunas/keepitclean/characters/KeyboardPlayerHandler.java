package org.acadmeiadecodigo.gnunas.keepitclean.characters;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.acadmeiadecodigo.gnunas.keepitclean.Direction;

public class KeyboardPlayerHandler implements KeyboardHandler {

    Keyboard kb;
    private Direction direction;
    private boolean moving;
    private boolean interacting;
    private int[] keyList;
    private boolean[] pressedKeys = new boolean[5];


    public KeyboardPlayerHandler(Direction direction, int up,int down,int left,int right,int space){
        this.direction =direction;
        moving = false;
        interacting = false;
        kb = new Keyboard(this);
        keyList= new int[]{up,down,left,right,space};

    }

    public boolean isInteracting() {
        return interacting;
    }

    public boolean isMoving() {
        return moving;
    }


    public void loadKboardConfig(){

        KeyboardEvent pressedUp = new KeyboardEvent();
        pressedUp.setKey(keyList[0]);
        pressedUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        kb.addEventListener(pressedUp);

        KeyboardEvent releasedUp = new KeyboardEvent();
        releasedUp.setKey(keyList[0]);
        releasedUp.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        kb.addEventListener(releasedUp);


        KeyboardEvent pressedDown = new KeyboardEvent();
        pressedDown.setKey(keyList[1]);
        pressedDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        kb.addEventListener(pressedDown);


        KeyboardEvent releasedDown = new KeyboardEvent();
        releasedDown.setKey(keyList[1]);
        releasedDown.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        kb.addEventListener(releasedDown);



        KeyboardEvent pressedLeft = new KeyboardEvent();
        pressedLeft.setKey(keyList[2]);
        pressedLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        kb.addEventListener(pressedLeft);



        KeyboardEvent releasedLeft = new KeyboardEvent();
        releasedLeft.setKey(keyList[2]);
        releasedLeft.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        kb.addEventListener(releasedLeft);



        KeyboardEvent pressedRight = new KeyboardEvent();
        pressedRight.setKey(keyList[3]);
        pressedRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        kb.addEventListener(pressedRight);



        KeyboardEvent releasedRight = new KeyboardEvent();
        releasedRight.setKey(keyList[3]);
        releasedRight.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        kb.addEventListener(releasedRight);

        KeyboardEvent pressedSpace = new KeyboardEvent();
        pressedSpace.setKey(keyList[4]);
        pressedSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        kb.addEventListener(pressedSpace);

        KeyboardEvent releasedSpace = new KeyboardEvent();
        releasedSpace.setKey(keyList[4]);
        releasedSpace.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        kb.addEventListener(releasedSpace);

    }

    private Direction moveNewDirection(){
        if(pressedKeys[0]){
            System.out.println("up");
            return Direction.UP;
        }

        if(pressedKeys[1]){
            System.out.println("down");
            return Direction.DOWN;
        }

        if(pressedKeys[2]){
            System.out.println("left");
            return Direction.LEFT;
        }

        if(pressedKeys[3]){
            System.out.println("right");
            return Direction.RIGHT;
        }

        return Direction.NONE;
    }


    public Direction getDirection() {
        return direction;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        moving = true;

        if(keyboardEvent.getKey()==keyList[0]){
            pressedKeys[0]=true;
        }

        if(keyboardEvent.getKey()==keyList[1]){
            pressedKeys[1]=true;
        }

        if(keyboardEvent.getKey()==keyList[2]){
            pressedKeys[2]= true;
        }
        if(keyboardEvent.getKey()==keyList[3]){
            pressedKeys[3]=true;
        }

        if(keyboardEvent.getKey()==keyList[4]){
            System.out.println("interaçao!");
            pressedKeys[4]=true;
            interacting=true;
        }

        direction = moveNewDirection();


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        moving = false;

        if(keyboardEvent.getKey()==keyList[0]){
            pressedKeys[0]=false;
        }

        if(keyboardEvent.getKey()==keyList[1]){
            pressedKeys[1]=false;
        }

        if(keyboardEvent.getKey()==keyList[2]){
            pressedKeys[2]= false;
        }
        if(keyboardEvent.getKey()==keyList[3]){
            pressedKeys[3]=false;
        }

        if(keyboardEvent.getKey()==keyList[4]){
            interacting=false;
        }

        if(direction== Direction.NONE){
            moving = false;
        }
    }




}
