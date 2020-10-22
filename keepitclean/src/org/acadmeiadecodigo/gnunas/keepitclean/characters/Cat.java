package org.acadmeiadecodigo.gnunas.keepitclean.characters;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.acadmeiadecodigo.gnunas.keepitclean.Level;
import org.acadmeiadecodigo.gnunas.keepitclean.objects.GameObject;
import org.acadmeiadecodigo.gnunas.keepitclean.objects.Poop;
import java.util.LinkedList;

import org.acadmeiadecodigo.gnunas.keepitclean.Direction;


public class Cat extends Character {

    private Picture catImage;
    private int counter = 15000;
    private LinkedList<Direction> list;
    private final int MIN = 100;
    private final int MAX = 300;
    private Level level;
    private boolean collided = false;

    public Cat(Level level) {
        this.level = level;
        list = new LinkedList<>();
        catImage = new Picture(500, 500, "Character/Cat_the_Cat_Right.png");
        catImage.draw();
    }

    public void checkCollisions() {

        if (catImage.getX() + 10 <= level.getField().getBackground().getX()) {
            System.out.println("Collision Left");
            move(Direction.RIGHT);
        }

        if (catImage.getMaxY() >= level.getField().getBackground().getMaxY()) {
            System.out.println("Collision Down");
            move(Direction.UP);

        }

        if (catImage.getY() <= level.getField().getBackground().getY() + 60) {
            System.out.println("Collision Top");
            move(Direction.DOWN);


        }

        if (catImage.getMaxX() - 10 >= level.getField().getBackground().getMaxX()) {
            System.out.println("Collision Right");
            move(Direction.LEFT);
        }

        for (GameObject go : level.getField().getObjects()) {

            if((catImage.getMaxX() >= go.getX() && catImage.getMaxY() >= go.getY()) && (catImage.getX() <= go.getMaxX() && catImage.getY() <= go.getMaxY())) {
                collided = true;
                System.out.println("Collided with " + go.getName());
            }
        }
    }

    public void poop() {
        level.getField().getObjects().add(new Poop(this));
    }

    public void move () throws InterruptedException {

        for (int i = 0; i < counter; i++) {

            collided = false;
            Direction dir = Direction.values()[(int) (Math.random() * Direction.values().length)];
            list.add(dir);
            Thread.sleep(500);
            //System.out.println(dir);

            if (dir == Direction.SIT) {
                poop();
            }

            int numOfMoves = (int) (Math.random() * (MAX - MIN) + MIN);

            for (int j = 0; j < numOfMoves; j++) {

                checkCollisions();
                System.out.println(collided);

                if (collided) {
                    move();
                    System.out.println("asdasdasdashfsahdfkhsadkfhaskdhfkasdhfksadhfkahsdfhasdlkfhalskjdhfl");
                    //numOfMoves = 0; //condição de saida para o segundo for( j)
                }else{
                    move(dir);
                }
                //System.out.println("cat moving" + " " + dir + " " + i);
            }
        }
    }

    public void colided(){

    }

    @Override
    public void move (Direction direction){


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

    public int getImageX () {
        return catImage.getMaxX();
    }

    public int getImageY () {
        return catImage.getMaxY();
    }

}
