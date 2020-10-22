package org.acadmeiadecodigo.gnunas.keepitclean.objects;

import org.acadmeiadecodigo.gnunas.keepitclean.Game;
import org.acadmeiadecodigo.gnunas.keepitclean.characters.Cat;

public class Poop extends GameObject implements Interactable {

    public Poop(Cat cat) {

        super(cat.getImageX(),cat.getImageY(),"Poop","GameObject/poop.png");
        clean = false;
        this.draw();
    }

    @Override
    public void interact() {
        Game.updateScore(100);
        System.out.println("score increase by 100");
    }
}
