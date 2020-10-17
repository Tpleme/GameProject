package org.acadmeiadecodigo.gnunas.keepitclean.characters;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.acadmeiadecodigo.gnunas.keepitclean.Directions;
import org.acadmeiadecodigo.gnunas.keepitclean.Field;
import org.acadmeiadecodigo.gnunas.keepitclean.Position;
import org.acadmeiadecodigo.gnunas.keepitclean.characters.Character;

public class Cat extends Character {

   private Picture catImage;
   private int movement = 0;
   private int counter = 15000;
  // private Poop poop;

    public Cat() {
        catImage = new Picture(500, 500, "Character/Cat_the_Cat.png");
        catImage.draw();

    }


    public void move() {


        for (int i = 0; i < counter; i++) {
            Directions dir = Directions.values() [(int)(Math.random() * Directions.values().length)];
            move(dir);
            System.out.println("cat moving" + " " + dir + i);
        }

    }


    @Override
    public void move(Directions direction) {

        switch (direction) {
            case UP:
                catImage.translate(0,-1);
                break;

            case DOWN:
                catImage.translate(0, 1);
                break;

            case RIGHT:
                catImage.translate(1,0);
                break;

            case LEFT:
                catImage.translate(-1,0);
                break;

            default:
                throw null;

        }


    }

    public void poop() {

    }

}
