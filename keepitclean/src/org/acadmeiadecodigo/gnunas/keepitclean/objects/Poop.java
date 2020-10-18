package org.acadmeiadecodigo.gnunas.keepitclean.objects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Poop extends GameObject implements Interactable {

    Picture poop;

    public Poop() {
        poop = new Picture(250, 250, "GameObject/poop.png");

    }

    @Override
    public void interact() {

    }
}
