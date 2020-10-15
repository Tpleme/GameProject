package org.acadmeiadecodigo.gnunas.keepitclean;

import org.acadmeiadecodigo.gnunas.keepitclean.characters.Cat;
import org.acadmeiadecodigo.gnunas.keepitclean.characters.Player;

public class Game {

    private Level level;
    private Player player;
    private Cat cat;
    private int score;

    public Game(){
        level = new Level();
        player = new Player();
    }

}
