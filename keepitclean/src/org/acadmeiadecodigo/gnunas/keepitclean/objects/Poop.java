package org.acadmeiadecodigo.gnunas.keepitclean.objects;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.acadmeiadecodigo.gnunas.keepitclean.characters.Cat;

public class Poop extends GameObject implements Interactable {

    Picture poop;
    private Cat cat;

    public Poop(Cat cat) {
        super(cat.getImageX(), cat.getImageY() , "GameObject/poop.png");
        this.cat = cat;
        this.draw();
    }

    @Override
    public void interact() {

    }
}
