package org.acadmeiadecodigo.gnunas.keepitclean.objects;

public class Table extends GameObject implements Interactable{

    public Table(int x, int y, String reference){
       super(x, y, reference);

    }

    @Override
    public void interact() {
        System.out.println("Interacting");
    }
}
