package org.acadmeiadecodigo.gnunas.keepitclean;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.acadmeiadecodigo.gnunas.keepitclean.objects.*;

import java.sql.Time;

public class Field {
    private int height;
    private int width;
    public static final int PADDING=10;
    private int offsetX;
    private int offsetY;
    private GameObject[] objects;
    private Rectangle screen;
    private Picture background;

    public Field(int width, int height){
        this.height = height;
        this.width = width;
        offsetX = (width / 8) + PADDING;
        offsetY = (height / 8) + PADDING;
        fillObjArr();
    }

    //Instancia os GameObjects desta sala e guarda-os num array de GameObjects
    private void fillObjArr(){

        GameObject table = new Table(696 + offsetX,206 + offsetY,"objects/Table.png");
        GameObject bookshelf = new Bookshelf(79 + offsetX,35 + offsetY,"objects/BookShelf.png");
        GameObject couch = new Couch(92 + offsetX, 200 + offsetY, "objects/couch.png");
        GameObject plant = new Plant(480 + offsetX, 42 + offsetY ,"objects/Plant.png");
        GameObject weed = new Weed((int) (170 + (Math.random() * (960 - 100))), 510,"GameObject/weed.png");

        objects = new GameObject[] {table,bookshelf,couch,plant, weed};
    }

    //Desenha o fundo, sala e os objetos contidos no array
    public void draw(){
       screen = new Rectangle(PADDING,PADDING,width,height);
       screen.fill();

       background = new Picture(offsetX,offsetY,"EmptyLivingRoom.png");
       background.draw();

       for (GameObject go : objects){
           go.draw();
       }

    }

    // para podermos fazer delete das pictures eventualmente
    public void deleteScene(){
        screen.delete();
        background.delete();
        for (GameObject go : objects){
            go.delete();
        }

    }

    public Picture getBackground() {
        return background;
    }

    public GameObject[] getObjects() {
        return objects;
    }


}
