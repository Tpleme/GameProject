package org.acadmeiadecodigo.gnunas.keepitclean;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
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
    private GameController menuController = new GameController();

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
        Picture menu = new Picture(0,0, "menus/menu.png");
        menu.draw();
        Picture heart = new Picture(430,270,"menus/heart.png");
        heart.draw();

        Rectangle arrow = new Rectangle(430,270,64,64);
        arrow.fill();
        SelectedOption current = currentOption;


        while (currentState == GameState.MAINMENU || currentState == GameState.INSTRUCTIONS) {

            if(currentOption != current){

                if (currentOption == SelectedOption.PLAY){
                   // arrow.delete();
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
        arrow.delete();

        menu.delete();

        /*while(!gameOver){
            play game here
        }*/

    }



    public void plot () throws InterruptedException {


        Picture menu = new Picture(170,100, "menus/tinder.png");
        menu.draw();
        Thread.sleep(4000);
        menu.delete();

        Picture menu2 = new Picture(170,100, "menus/superlike.png");
        menu2.draw();
        Thread.sleep(4000);
        menu2.delete();

        Picture menu3 = new Picture(170,100, "menus/answer.png");
        menu3.draw();
        Thread.sleep(6000);
        menu3.delete();

        Picture menu4 = new Picture(170,100,"menus/oops.png");
        menu4.draw();
        Thread.sleep(6000);
        menu4.delete();




    }



    public void start(){
        level = new Level();
        player = new Player(level);
        cat = new Cat();
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



