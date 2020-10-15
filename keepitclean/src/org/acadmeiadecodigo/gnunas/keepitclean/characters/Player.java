package org.acadmeiadecodigo.gnunas.keepitclean.characters;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.acadmeiadecodigo.gnunas.keepitclean.Directions;
import org.acadmeiadecodigo.gnunas.keepitclean.Position;
import org.acadmeiadecodigo.gnunas.keepitclean.characters.Character;

public class Player extends Character implements KeyboardHandler {
    Keyboard kb;
    Picture playerImage;

    public Player() {
        playerImage = new Picture(500,500, "Character/CharacterFront.png");
        kb = new Keyboard(this);
        init();
        playerHandler();
    }

    public void init(){
        playerImage.draw();
    }

    @Override
    public void move(Directions direction) {

        switch (direction){
            case DOWN -> playerImage.translate(0,10);
            case UP -> playerImage.translate(0,-10);
            case RIGHT -> playerImage.translate(10,0);
            case LEFT -> playerImage.translate(-10,0);
        }
    }

 public void playerHandler(){
    KeyboardEvent kbEventSpace = new KeyboardEvent();
    kbEventSpace.setKey(KeyboardEvent.KEY_SPACE);
    kbEventSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
    kb.addEventListener(kbEventSpace);


     KeyboardEvent kbEventUp = new KeyboardEvent();
     kbEventUp.setKey(KeyboardEvent.KEY_UP);
     kbEventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
     kb.addEventListener(kbEventUp);


     KeyboardEvent kbEventDown = new KeyboardEvent();
     kbEventDown.setKey(KeyboardEvent.KEY_DOWN);
     kbEventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
     kb.addEventListener(kbEventDown);


     KeyboardEvent kbEventRight = new KeyboardEvent();
     kbEventRight.setKey(KeyboardEvent.KEY_RIGHT);
     kbEventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
     kb.addEventListener(kbEventRight);


     KeyboardEvent kbEventLeft = new KeyboardEvent();
     kbEventLeft.setKey(KeyboardEvent.KEY_LEFT);
     kbEventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
     kb.addEventListener(kbEventLeft);
 }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            System.out.println("space");
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
            System.out.println("down");
            move(Directions.DOWN);
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
            System.out.println("UP");
            move(Directions.UP);
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            System.out.println("left");
            move(Directions.LEFT);
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            System.out.println("right");
            move(Directions.RIGHT);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
