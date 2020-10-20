package org.acadmeiadecodigo.gnunas.keepitclean;

import org.acadmeiadecodigo.gnunas.keepitclean.characters.Cat;

public class Main {
    public static void main(String[] args){

        try {
            Game game = new Game();

            game.init();

            game.start();
        }
        catch (InterruptedException interruptedException){
            System.out.println(interruptedException.getMessage());
        }
    }
}
