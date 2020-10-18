package org.acadmeiadecodigo.gnunas.keepitclean.characters;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.acadmeiadecodigo.gnunas.keepitclean.Direction;
import org.acadmeiadecodigo.gnunas.keepitclean.Position;
import org.acadmeiadecodigo.gnunas.keepitclean.characters.Character;



public class Player extends Character {

    private KeyboardPlayerHandler kbPlayerHandler;
    private Direction direction;
    Picture playerImage;


    public Player() {
        playerImage = new Picture(500,500, "Character/CharacterFront.png");
        init();
        kbConfiguration();

       // playerHandler();
    }

    public void kbConfiguration(){
        kbPlayerHandler = new KeyboardPlayerHandler(direction,PlayerKey.KEY.getUp(), PlayerKey.KEY.getDown(), PlayerKey.KEY.getLeft(), PlayerKey.KEY.getRight(), PlayerKey.KEY.getSpace());
        System.out.println("criado");
        kbPlayerHandler.loadKboardConfig();
    }


    public void init(){
        playerImage.draw();
    }


    public void checkMovement(){
        if(kbPlayerHandler.isMoving()){
            move(chooseDirection());
        }
    }


    public Direction chooseDirection(){
        Direction nextDirection = kbPlayerHandler.getDirection();

        return nextDirection;
    }


    @Override
    public void move(Direction direction) {


        //
        // playerDirection = direction
        // field.moveDirection (direction,this)
        // field tem de ter a conversao para X,Y com os Translates lá.



        switch (direction){
            case DOWN -> {
                playerImage.translate(0,10);
                playerImage.load("Character/CharacterFront.png");
            }
            case UP -> {
                playerImage.translate(0,-10);
                playerImage.load("Character/CharacterBack.png");
            }
            case RIGHT -> {
                playerImage.translate(10,0);
                playerImage.load("Character/CharacterRight.png");
            }
            case LEFT -> {
                playerImage.translate(-10,0);
                playerImage.load("Character/CharacterLeft.png");
            }
        }
    }


}
