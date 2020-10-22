package org.acadmeiadecodigo.gnunas.keepitclean.objects;

public class Table extends GameObject implements Interactable{

    public Table(int x, int y, String name, String reference){
       super(x, y, name, reference);

    }

    @Override
    public void interact() {
        System.out.println("interacting with table");
        this.objectPicture.load("resources/objects/Table.png");
    }
}
