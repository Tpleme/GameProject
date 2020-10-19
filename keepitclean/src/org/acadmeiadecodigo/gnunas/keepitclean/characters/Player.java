package org.acadmeiadecodigo.gnunas.keepitclean.characters;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.acadmeiadecodigo.gnunas.keepitclean.Directions;
import org.acadmeiadecodigo.gnunas.keepitclean.Level;
import org.acadmeiadecodigo.gnunas.keepitclean.objects.Bookshelf;
import org.acadmeiadecodigo.gnunas.keepitclean.objects.GameObject;

public class Player extends Character implements KeyboardHandler {
    Keyboard kb;
    Picture playerImage;
    private boolean movingUp = false;
    private boolean movingDown = false;
    private boolean movingLeft = false;
    private boolean movingRight = false;
    private boolean canMoveUp = true;
    private boolean canMoveDown = true;
    private boolean canMoveRight = true;
    private boolean canMoveLeft = true;
    private Level level;

    public Player(Level level) {
        playerImage = new Picture(500,500, "Character/CharacterFront.png");
        kb = new Keyboard(this);
        this.level = level;

        init();
        playerHandler();
    }

    public void init(){
        playerImage.draw();
    }

    public void checkCollisions(){

        if(playerImage.getX() <= level.getField().getBackground().getX()) {
            canMoveLeft = !movingLeft;
            System.out.println("Collision Left");
        }
        if(playerImage.getMaxY() >= level.getField().getBackground().getMaxY()){
            canMoveDown = !movingDown;
            System.out.println("Collision Down");
        }
        if(playerImage.getY() <= level.getField().getBackground().getY() + 60) {
            System.out.println("Collision Top");
            canMoveUp = !movingUp;
        }
        if(playerImage.getMaxX() >= level.getField().getBackground().getMaxX()){
            System.out.println("Collision Right");
            canMoveRight = !movingRight;
        }

        for (GameObject go : level.getField().getObjects()) {
            if((playerImage.getMaxX() >= go.getX() && playerImage.getMaxY() >= go.getY()) && (playerImage.getX() <= go.getMaxX() && playerImage.getY()+40 <= go.getMaxY())) {
                System.out.println("Collision " + go.toString());
                canMoveUp = !movingUp;
                canMoveDown = !movingDown;
                canMoveRight = !movingRight;
                canMoveLeft = !movingLeft;
            }
        }
    }

    @Override
    public void move(Directions direction) {

        checkCollisions();

        switch (direction){
            case DOWN -> {
                if(canMoveDown) {
                    canMoveUp = true;
                    canMoveLeft = true;
                    canMoveRight = true;

                    movingDown = true;
                    movingUp = false;
                    movingRight = false;
                    movingLeft = false;
                    playerImage.translate(0, 10);
                    playerImage.load("Character/CharacterFront.png");
                }
            }
            case UP -> {
                if(canMoveUp) {
                    canMoveDown = true;
                    canMoveRight = true;
                    canMoveLeft = true;

                    movingDown = false;
                    movingUp = true;
                    movingRight = false;
                    movingLeft = false;
                    playerImage.translate(0, -10);
                    playerImage.load("Character/CharacterBack.png");
                }
            }
            case RIGHT -> {
                if(canMoveRight) {
                    canMoveDown = true;
                    canMoveUp = true;
                    canMoveLeft = true;

                    movingDown = false;
                    movingUp = false;
                    movingRight = true;
                    movingLeft = false;
                    playerImage.translate(10, 0);
                    playerImage.load("Character/CharacterRight.png");
                }
            }
            case LEFT -> {
                if(canMoveLeft) {
                    canMoveUp = true;
                    canMoveDown = true;
                    canMoveRight = true;

                    movingDown = false;
                    movingUp = false;
                    movingRight = false;
                    movingLeft = true;
                    playerImage.translate(-10, 0);
                    playerImage.load("Character/CharacterLeft.png");
                }
            }
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
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
            move(Directions.DOWN);
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
            move(Directions.UP);
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            move(Directions.LEFT);
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            move(Directions.RIGHT);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
