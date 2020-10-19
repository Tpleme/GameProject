package org.acadmeiadecodigo.gnunas.keepitclean.objects;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Weed extends GameObject implements Interactable{

    Keyboard kb;
    Picture weedImage;
    boolean pickup;
    int choice;
    int counter;


    public Weed() {

        weedImage = new Picture((int)(Math.random()*170),(int)(Math.random()*100), "Character/weedleaf.png");
        pickup = false;
        counter = 0;

        weedImage.draw();
        interact();
        //weedImage.delete();
    }

    @Override
    public void interact() {

        pickup = true;
        choice = (int)(Math.random()*2);

        if ((choice == 0)) {
            goodTrip();

        } else {
            badTrip();
        }
    }

    public void goodTrip(){

        System.out.println("Good trip");
    }

    public void badTrip(){

        System.out.println("Bad trip");
    }

    public boolean isPickup(){
        return pickup;
    }

    public void pickUpWeed(){

    }


}
