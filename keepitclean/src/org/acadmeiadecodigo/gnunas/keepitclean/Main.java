package org.acadmeiadecodigo.gnunas.keepitclean;

import org.acadmeiadecodigo.gnunas.keepitclean.characters.Cat;

public class Main {
    public static void main(String[] args){

        Sound sound = new Sound("/resources/Sound/ArcadeKid.wav");
        sound.play(true);

        try {

            Thread.sleep(100);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        try {
            Game game = new Game();

            game.init();
            game.plot();
            game.start();
        }
        catch (InterruptedException interruptedException){
            System.out.println(interruptedException.getMessage());
        }
    }
}
