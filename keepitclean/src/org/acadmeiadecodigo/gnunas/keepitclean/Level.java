package org.acadmeiadecodigo.gnunas.keepitclean;

import org.acadmeiadecodigo.gnunas.keepitclean.objects.GameObject;
import org.acadmeiadecodigo.gnunas.keepitclean.objects.Poop;

public class Level {
    private Field field;

    public Level(){
        field = new Field(1280,720);
        init();
    }

    public void win(){
        int numberOfCleanObjects = 0;

        for(GameObject gameObject : field.getObjects()){
            if (gameObject.isClean()){
                numberOfCleanObjects++;
            }
        }

        if (numberOfCleanObjects >= 6){
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
