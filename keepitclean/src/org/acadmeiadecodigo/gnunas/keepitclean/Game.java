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
    private int score;
    public static GameState currentState;


    public Game() {
        level = new Level();
        player = new Player(level);
        cat = new Cat();
        showScore();

        cat.move();
        currentState = GameState.MAINMENU;

    }

    public void showScore() {

        Text txt = new Text(100, 50, "Score...");
        txt.grow(50, 25);
        txt.setColor(Color.RED);
        txt.draw();
    }


    public void init() {

        while (currentState == GameState.MAINMENU || currentState == GameState.INSTRUCTIONS) {

        }

        /*while(!gameOver){
            play game here
        }*/

    }


    public void exit() {
        System.exit(0);
    }
}



