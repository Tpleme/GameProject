package org.acadmeiadecodigo.gnunas.keepitclean;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.acadmeiadecodigo.gnunas.keepitclean.characters.Cat;
import org.acadmeiadecodigo.gnunas.keepitclean.characters.Player;
import org.acadmeiadecodigo.gnunas.keepitclean.objects.Weed;

public class Game {

    private Level level;
    private Player player;
    private Cat cat;
    private Weed weed;
    private int score;

    public Game(){
        level = new Level();
        player = new Player();
        cat = new Cat();
        weed = new Weed();
        showScore();
    }

    public void showScore(){
        Text txt = new Text(50,50,"Score...");
        txt.grow(20,10);
        txt.setColor(Color.RED);
        txt.draw();
    }



}
