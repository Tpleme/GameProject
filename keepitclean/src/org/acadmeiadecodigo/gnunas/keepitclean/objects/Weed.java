package org.acadmeiadecodigo.gnunas.keepitclean.objects;

import org.acadmeiadecodigo.gnunas.keepitclean.characters.Player;

import java.util.Timer;
import java.util.TimerTask;

public class Weed extends GameObject implements Interactable{

    public Weed(int xPos , int yPos, String reference) {

        super(xPos, yPos, "Weed", reference);
        clean = true;
    }

        @Override
        public void interact() {

            if (((int) (Math.random() * 2) == 0)) {
                goodTrip();
            } else {
                badTrip();
            }

            Timer weedTimer = new Timer();
            weedTimer.scheduleAtFixedRate(new TimerTask() {

                @Override
                public void run() {
                    Player.speed = 10;
                    weedTimer.cancel();
                }
            }, 10000,10000);

        }

    public void goodTrip() {

            Player.speed = 15;
            System.out.println("Good trip");
        }

        public void badTrip() {

            Player.speed = 5;
            System.out.println("Bad trip");
        }
}
