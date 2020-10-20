package org.acadmeiadecodigo.gnunas.keepitclean.objects;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Weed extends GameObject implements Interactable{


        Picture weedImage;
        boolean pickup;
        int choice;


    public Weed(int xPos , int yPos, String reference) {

        super(xPos, yPos, reference);

    }


        @Override
        public void interact() {

            pickup = true;
            choice = (int) (Math.random() * 2);

            if ((choice == 0)) {
                goodTrip();

            } else {
                badTrip();
            }
        }

    @Override
    public void delete() {
        weedImage.delete();
    }

    public void goodTrip() {

            System.out.println("Good trip");
        }

        public void badTrip() {

            System.out.println("Bad trip");
        }

        public boolean isPickup() {
            return pickup;
        }

        public void pickUpWeed() {

        }
    }
