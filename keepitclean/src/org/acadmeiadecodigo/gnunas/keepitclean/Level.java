package org.acadmeiadecodigo.gnunas.keepitclean;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.acadmeiadecodigo.gnunas.keepitclean.objects.GameObject;

public class Level {
    private Field field;
    int numberOfCleanObjects;
    boolean gameOver;
    private Game game;

    public Level(Game game){
        this.game = game;
        gameOver = false;
        field = new Field(1280,720);
        init();
    }

    public void win(){

        numberOfCleanObjects = 0;

        for(GameObject gameObject : field.getObjects()){
            if (gameObject.isClean()){
                numberOfCleanObjects++;
            }
        }

        if (numberOfCleanObjects == field.getObjects().size()) {
            game.winGame();
        }
    }

    private void init(){
        field.draw();
    }

    public Field getField() {
        return field;
    }
}
