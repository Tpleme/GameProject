package org.acadmeiadecodigo.gnunas.keepitclean;

public class Level {
    private Field field;
    private int timer;

    public Level(){
        field = new Field(1280,720);
        init();
    }

    private void init(){
        field.draw();
    }

}
