package org.acadmeiadecodigo.gnunas.keepitclean.characters;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.acadmeiadecodigo.gnunas.keepitclean.Directions;
import org.acadmeiadecodigo.gnunas.keepitclean.characters.Character;

public class Cat extends Character {

    Picture catImage;

    public Cat() {
        catImage = new Picture(500,500,"Character/Cat_the_Cat.png");
        catImage.draw();
    }

    @Override
    public void move(Directions direction) {

    }

    public void poop(){}

}
