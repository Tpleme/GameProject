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
    public static GameState currentState;


    public Game(){
        level = new Level();
        player = new Player();
        cat = new Cat();
        showScore();

        cat.move();
        currentState = GameState.MAINMENU;

    }

    public void showScore(){
        Text txt = new Text(50,50,"Score...");
        txt.grow(20,10);
        txt.setColor(Color.RED);
        txt.draw();
    }

    public void init(){

        while(currentState == GameState.MAINMENU || currentState == GameState.INSTRUCTIONS){

        }

        /*while(!gameOver){
            play game here
        }*/

    }

    public enum GameState{
        MAINMENU,
        PLAYING,
        INSTRUCTIONS
    }

    public void exit(){
        System.exit(0);
    }
}
