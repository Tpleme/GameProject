package org.acadmeiadecodigo.gnunas.keepitclean.objects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class GameObject {

    protected Picture objectPicture;
    protected int x;
    protected int y;
    protected int maxX;
    protected int maxY;
    protected String name;

    public GameObject(int x, int y, String name, String reference){
        objectPicture = new Picture(x,y,reference);
        this.name = name;
        this.x = x;
        this.y = y;
        this.maxX = objectPicture.getMaxX();
        this.maxY = objectPicture.getMaxY();
    }

    public String getName() {
        return name;
    }

    public void delete(){

        objectPicture.delete();
    }

    public void draw(){
        objectPicture.draw();
    }

    public int getX() {
        return x;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getY() {
        return y;
    }

    public int getMaxY() {
        return maxY;
    }

    @Override
    public String toString() {
        return name;
    }

}
