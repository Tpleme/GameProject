package org.acadmeiadecodigo.gnunas.keepitclean;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends Character implements KeyboardHandler {
    Keyboard kb;

    Picture picture;

    public Player() {
        picture = new Picture(400,400,"sofia_pixels_mc.png");
        kb = new Keyboard(this);
        init();
        playerHandler();

    }

    public void init(){
        picture.draw();
    }

    @Override
    public void move(String dir) {

        switch (dir){
            case "S" -> picture.translate(10,0);
        }
    }

 public void playerHandler(){
    KeyboardEvent kbEvent = new KeyboardEvent();
    kbEvent.setKey(KeyboardEvent.KEY_SPACE);
    kbEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
    kb.addEventListener(kbEvent);


     KeyboardEvent kbEvent1 = new KeyboardEvent();
     kbEvent1.setKey(KeyboardEvent.KEY_UP);
     kbEvent1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
     kb.addEventListener(kbEvent1);
 }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            System.out.println("space");
            move("S");
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
            System.out.println("down");
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
            System.out.println("UP");
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            System.out.println("left");
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            System.out.println("right");
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
