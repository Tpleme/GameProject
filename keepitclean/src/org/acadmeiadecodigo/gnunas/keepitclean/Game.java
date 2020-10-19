package org.acadmeiadecodigo.gnunas.keepitclean;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.acadmeiadecodigo.gnunas.keepitclean.characters.Cat;
import org.acadmeiadecodigo.gnunas.keepitclean.characters.Player;

public class Game {

    private Level level;
    private Player player;
    private Cat cat;
    private int score;

    public Game(){
        level = new Level();
        player = new Player(level);
        cat = new Cat();
        showScore();
    }

    public void showScore(){

        Text txt = new Text(100,50,"Score...");
        txt.grow(50,25);
        txt.setColor(Color.RED);
        txt.draw();

    }
}
