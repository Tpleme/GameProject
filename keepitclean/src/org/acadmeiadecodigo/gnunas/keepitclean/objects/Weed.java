package org.acadmeiadecodigo.gnunas.keepitclean.objects;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Weed extends GameObject implements Interactable{

        private Picture weedImage;
        private boolean pickup;
        private int choice;

    public Weed(int xPos , int yPos, String reference) {

        super(xPos, yPos, "Weed", reference);
    }

        @Override
        public void interact() {

            System.out.println("Interacting with " + name);

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
