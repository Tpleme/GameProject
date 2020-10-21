package org.acadmeiadecodigo.gnunas.keepitclean;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.acadmeiadecodigo.gnunas.keepitclean.characters.Cat;
import org.acadmeiadecodigo.gnunas.keepitclean.characters.Player;
import org.acadmeiadecodigo.gnunas.keepitclean.objects.Weed;

public class Game {

    private Level level;
    private Player player;
    private Cat cat;
    private int score;
    public static GameState currentState;
    public static SelectedOption currentOption ;


    public Game() {

        currentState = GameState.MAINMENU;
        currentOption = SelectedOption.PLAY;

    }

    public void showScore() {

        Text txt = new Text(100, 50, "Score...");
        txt.grow(50, 25);
        txt.setColor(Color.RED);
        txt.draw();
    }


    public void init() throws InterruptedException{
        Picture menu = new Picture(0,0, "menus/menus.png");
        menu.draw();
        Rectangle arrow = new Rectangle(430,270,64,64);
        arrow.fill();
        SelectedOption current = currentOption;
        GameController menuController = new GameController();

        while (currentState == GameState.MAINMENU || currentState == GameState.INSTRUCTIONS) {

            if(currentOption != current){

                if (currentOption == SelectedOption.PLAY){
                    arrow.delete();
                    arrow = new Rectangle(430,270,64,64);
                    arrow.fill();
                }
                if (currentOption == SelectedOption.INSTRUCTIONS){
                    arrow.delete();
                    arrow = new Rectangle(430,360,64,64);
                    arrow.fill();
                }
                if (currentOption == SelectedOption.QUIT){
                    arrow.delete();
                    arrow = new Rectangle(430, 450,64,64);
                    arrow.fill();
                }

            }

            current = currentOption;

            Thread.sleep(50);
        }

        menu.delete();

        /*while(!gameOver){
            play game here
        }*/

    }

    public void start(){
        level = new Level();
        player = new Player(level);
        cat = new Cat(level);
        showScore();

        cat.move();


    }


    public static void exit() {
        System.exit(0);
    }

    public enum SelectedOption {
        PLAY,
        INSTRUCTIONS,
        QUIT
    }
}



