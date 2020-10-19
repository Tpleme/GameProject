package org.acadmeiadecodigo.gnunas.keepitclean.characters;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import org.acadmeiadecodigo.gnunas.keepitclean.objects.Poop;

import java.util.LinkedList;

import org.acadmeiadecodigo.gnunas.keepitclean.Direction;


public class Cat extends Character {

    private Picture catImage;
    private int counter = 15000;
    private LinkedList<Direction> list;
    private final int MIN = 100;
    private final int MAX = 300;


    public Cat() {

        list = new LinkedList<>();
        catImage = new Picture(500, 500, "Character/Cat_the_Cat_Right.png");
        catImage.draw();
    }

    public void move() {

        for (int i = 0; i < counter; i++) {
            Direction dir = Direction.values()[(int) (Math.random() * Direction.values().length)];
            list.add(dir);
            System.out.println(dir);

            if(dir == Direction.SIT) {
                poop();
            }

            for (int j = 0; j < (Math.random() * (MAX - MIN) + MIN); j++) {
                move(dir);
                System.out.println("cat moving" + " " + dir + " " + i);
            }
        }
    }

    @Override
    public void move(Direction direction) {

        switch (direction) {
            case UP:
                catImage.translate(0, -1);
                if (list.lastIndexOf(direction.RIGHT) > list.indexOf(direction.LEFT)) {
                    catImage.load("Character/Cat_the_Cat_Right.png");
                    break;
                }
                catImage.load("Character/Cat_the_Cat_LEFT.png");
                break;

            case DOWN:
                catImage.translate(0, 1);
                if (list.lastIndexOf(direction.RIGHT) > list.indexOf(direction.LEFT)) {
                    catImage.load("Character/Cat_the_Cat_Right.png");
                    break;
                }
                catImage.load("Character/Cat_the_Cat_LEFT.png");
                break;

            case RIGHT:
                catImage.translate(1, 0);
                catImage.load("Character/Cat_the_Cat_Right.png");
                break;

            case LEFT:
                catImage.translate(-1, 0);
                catImage.load("Character/Cat_the_Cat_LEFT.png");
                break;

            case DIAGONAL_DOWN_RIGHT:
                catImage.translate(1, 1);
                catImage.load("Character/Cat_the_Cat_Right.png");
                break;

            case DIAGONAL_UP_RIGHT:
                catImage.translate(1, -1);
                catImage.load("Character/Cat_the_Cat_Right.png");
                break;

            case DIAGONAL_DOWN_LEFT:
                catImage.translate(-1, 1);
                catImage.load("Character/Cat_the_Cat_LEFT.png");
                break;

            case DIAGONAL_UP_LEFT:
                catImage.translate(-1, -1);
                catImage.load("Character/Cat_the_Cat_LEFT.png");
                break;

            case SIT:
                catImage.translate(0, 0); // TEMP IMAGE
                catImage.load("Character/cat_sit_poop.png");
                break;


            default:
                throw new IllegalStateException();

        }
    }

    public void poop() {
        System.out.println("PPPPPOOOOOOPPED");
        new Poop(this);
    }

    public int getImageX() {
        return catImage.getX() + 32;
    }

    public int getImageY() {
        return catImage.getY() + 32;
    }

}
