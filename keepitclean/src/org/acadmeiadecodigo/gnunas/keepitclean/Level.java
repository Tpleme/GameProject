package org.acadmeiadecodigo.gnunas.keepitclean;

import org.acadmeiadecodigo.gnunas.keepitclean.objects.GameObject;

public class Level {
    private Field field;
    int numberOfCleanObjects;

    public Level(){
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
            System.out.println("WIN");
        }
    }

    private void init(){
        field.draw();
    }

    public Field getField() {
        return field;
    }
}
