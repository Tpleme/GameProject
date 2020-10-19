package org.acadmeiadecodigo.gnunas.keepitclean.characters;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

public enum PlayerKey {
   KEY(new int[]{KeyboardEvent.KEY_UP, KeyboardEvent.KEY_DOWN,KeyboardEvent.KEY_LEFT,KeyboardEvent.KEY_RIGHT,KeyboardEvent.KEY_SPACE});

   private int [] keys;

    PlayerKey(int[] keys) {
        this.keys = keys;
    }

    public int getSpace(){
        return keys[4];
    }

    public int getUp(){
        return keys[0];
    }

    public int getDown(){
        return keys[1];
    }

    public int getLeft(){
        return keys[2];
    }

    public int getRight(){
        return keys[3];
    }


}
