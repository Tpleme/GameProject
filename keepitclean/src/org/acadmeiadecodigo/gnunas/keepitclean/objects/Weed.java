package org.acadmeiadecodigo.gnunas.keepitclean.objects;

public class Weed extends GameObject implements Interactable{

        private int choice;

    public Weed(int xPos , int yPos, String reference) {

        super(xPos, yPos, "Weed", reference);
    }

        @Override
        public void interact() {

            if (((int) (Math.random() * 2) == 0)) {
                goodTrip();
            } else {
                badTrip();
            }



        }
    public void goodTrip() {

        System.out.println("Good trip");
    }

    public void badTrip() {

        System.out.println("Bad trip");
    }
}
