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

    public Field(int height,int width){
        this.height=height;
        this.width=width;
    }

    public void draw(){
       Rectangle screen = new Rectangle(PADDING,PADDING,width,height);

        screen.fill();

       // int calcWidth = (screen.getWidth()/4)+PADDING;
        //int calcHeight = (screen.getHeight()/4)+PADDING;
        //Rectangle small = new Rectangle(170,100,960,540);

        Picture fundo = new Picture(170,100,"fundo.jpg");
        fundo.draw();
        // small.setColor(Color.WHITE);
       // small.fill();
    }
}
