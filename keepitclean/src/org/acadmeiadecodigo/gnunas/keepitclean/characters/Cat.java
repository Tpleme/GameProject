package org.acadmeiadecodigo.gnunas.keepitclean.characters;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import org.acadmeiadecodigo.gnunas.keepitclean.Level;

import org.acadmeiadecodigo.gnunas.keepitclean.objects.GameObject;
import org.acadmeiadecodigo.gnunas.keepitclean.objects.Interactable;
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

    private boolean collision = false;



    public Cat(Level level) {

        this.level = level;
        list = new LinkedList<>();
        catImage = new Picture(500, 500, "Character/Cat_the_Cat_Right.png");
        catImage.draw();
    }

    public void checkCollisions() {

        if (catImage.getX() + 10 <= level.getField().getBackground().getX()) {
            System.out.println("Collision Left");
            //collision = true;
            move(Direction.RIGHT);


        }

        if (catImage.getMaxY() >= level.getField().getBackground().getMaxY()) {
            System.out.println("Collision Down");
            //collision = true;
            move(Direction.UP);

        }

        if (catImage.getY() <= level.getField().getBackground().getY() + 60) {
            System.out.println("Collision Top");
            //collision = true;
            move(Direction.DOWN);


        }

        if (catImage.getMaxX() - 10 >= level.getField().getBackground().getMaxX()) {
            System.out.println("Collision Right");
            //collision = true;
            move(Direction.LEFT);


        }

        for (GameObject go : level.getField().getObjects()) {

            //pequeno bounce para que nao continue a registar como collided
                /*if(movingUp) {catImage.translate(0,2);}
                if(movingDown){catImage.translate(0,-2);}
                if(movingRight){catImage.translate(-2,0);}
                if(movingLeft){catImage.translate(2,0);}


                canMoveUp = !movingUp;
                canMoveDown = !movingDown;
                canMoveRight = !movingRight;
                canMoveLeft = !movingLeft;*/

            if(catImage.getMaxX() >= go.getX()) {
                System.out.println("Collision " + go.toString());

                if(go instanceof Interactable)
                    ((Interactable) go).interact();

                //collision = true;
                move(Direction.LEFT);
                return;
            }

            if(catImage.getMaxY() >= go.getY()) {
                System.out.println("Collision " + go.toString());

                if(go instanceof Interactable)
                    ((Interactable) go).interact();

                //collision = true;
                move(Direction.UP);
                return;

            }
            if(catImage.getX() <= go.getMaxX()) {
                System.out.println("Collision " + go.toString());

                if(go instanceof Interactable)
                    ((Interactable) go).interact();

                //collision = true;
                move(Direction.RIGHT);
                return;

            }
            if(catImage.getY() <= go.getMaxY()) {
                System.out.println("Collision " + go.toString());

                if(go instanceof Interactable)
                    ((Interactable) go).interact();

                //collision = true;
                move(Direction.DOWN);
                return;

            }

        }
    }

            public void move () {

                for (int i = 0; i < counter; i++) {
                    Direction dir = Direction.values()[(int) (Math.random() * Direction.values().length)];
                    list.add(dir);
                    System.out.println(dir);

                    if (dir == Direction.SIT) {
                        poop();
                    }

                    int numOfMoves = (int) (Math.random() * (MAX - MIN) + MIN);

                    for (int j = 0; j < numOfMoves; j++) {
                        move(dir);
                        checkCollisions();
                        /*if (collision) {
                            numOfMoves = 0; //condição de saida para o segundo for( j)
                        }*/
                        System.out.println("cat moving" + " " + dir + " " + i);
                    }
                }
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

            public void poop () {
                System.out.println("PPPPPOOOOOOPPED");
                new Poop(this);
            }

            public int getImageX () {
                return catImage.getMaxX();
            }

            public int getImageY () {
                return catImage.getMaxY();
            }

        }
