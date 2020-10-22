package org.acadmeiadecodigo.gnunas.keepitclean.objects;

public class Plant extends GameObject implements Interactable{

    public Plant(int x, int y, String name, String reference){
        super(x, y, name, reference);
    }

    @Override
    public void interact() {
        System.out.println("Interacting with plant");
        this.objectPicture.load("resources/objects/Plant.png");
    }
}
