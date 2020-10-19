package org.acadmeiadecodigo.gnunas.keepitclean;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {
    private int height;
    private int width;
    public static final int PADDING=10;

    public Field(int width, int height){
        this.height=height;
        this.width=width;
    }

    public void draw(){
       Rectangle screen = new Rectangle(PADDING,PADDING,width,height);

        screen.fill();

        Picture background = new Picture(170,100,"livingRoom.png");
        background.draw();

    }

    public void movePlayer(Direction direction){


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
