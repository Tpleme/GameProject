package org.acadmeiadecodigo.gnunas.keepitclean.objects;

import org.acadmeiadecodigo.gnunas.keepitclean.characters.Cat;

public class Poop extends GameObject implements Interactable {

    public Poop(Cat cat) {
        super(cat.getImageX(),cat.getImageY(),"Poop","GameObject/poop.png");
        this.draw();
    }

    @Override
    public void interact() {
        System.out.println("Interacting with " + name);
    }
}
