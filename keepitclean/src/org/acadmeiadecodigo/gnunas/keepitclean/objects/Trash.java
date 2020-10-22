package org.acadmeiadecodigo.gnunas.keepitclean.objects;

public class Trash extends GameObject implements Interactable{

    public Trash(int x, int y, String name, String reference) {
        super(x,y,name,reference);
    }

    @Override
    public void interact() {
        if(!clean) {
            clean = true;
        }
        this.objectPicture.load("resources/objects/Trash.png");
    }
}
