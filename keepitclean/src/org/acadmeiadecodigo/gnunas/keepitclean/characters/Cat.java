package org.acadmeiadecodigo.gnunas.keepitclean.characters;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.acadmeiadecodigo.gnunas.keepitclean.GameState;
import org.acadmeiadecodigo.gnunas.keepitclean.Level;
import org.acadmeiadecodigo.gnunas.keepitclean.objects.GameObject;
import org.acadmeiadecodigo.gnunas.keepitclean.objects.Interactable;
import org.acadmeiadecodigo.gnunas.keepitclean.objects.Poop;
import org.acadmeiadecodigo.gnunas.keepitclean.objects.Weed;
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

      if (catImage.getX() <= level.getField().getBackground().getX() + 5) {
          System.out.println("Collision Left");
          move(Direction.RIGHT);
          collided = true;
          return;
      }

      if (catImage.getMaxY() >= level.getField().getBackground().getMaxY() - 5) {
          move(Direction.UP);
          collided = true;
          return;
      }

      if (catImage.getY() <= level.getField().getBackground().getY() + 80) {
          move(Direction.DOWN);
          collided = true;
          return;

      }

      if (catImage.getMaxX() >= level.getField().getBackground().getMaxX() - 5) {
          move(Direction.LEFT);
          collided = true;
          return;
      }
  }

    public void checkCollisionsObjects() {
        for (GameObject go : level.getField().getObjects()) {

            if (!(go instanceof Poop) && !(go instanceof Weed)  && (catImage.getMaxX() >= go.getX()+5 && catImage.getMaxY() >= go.getY()+5) && (catImage.getX() <= go.getMaxX()-5 && catImage.getY() <= go.getMaxY()-5)) {
               // System.out.println("Collided with " + go.getName());
                move(list.getLast().opposite());
                collided = true;
            }
        }
    }

      public void poop() {
          level.getField().getObjects().add(new Poop(this));
      }


      public Direction getDirection() {
          Direction dir = Direction.values()[(int) (Math.random() * Direction.values().length)];
          return dir;
      }

      public void move () throws InterruptedException {
          collided = false;

          for (int i = 0; i < counter; i++) {

              int numOfMoves = (int) (Math.random() * (MAX - MIN) + MIN);
              Direction dir = getDirection();
              list.add(dir);
              Thread.sleep(500);

              if (dir == Direction.SIT) {

                  numOfMoves = 0;
                  Thread.sleep(1500);
                  poop();
              }

              while (!collided && numOfMoves != 0) {

                  move(dir);
                  numOfMoves--;
                  checkCollisions();
                  checkCollisionsObjects();

              }
              collided = false;
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
                catImage.translate(0, 0);
                break;

            default:
                throw new IllegalStateException();
        }
    }

    public int getImageX() {
        return catImage.getMaxX() - 20;
    }

    public int getImageY() {
        return catImage.getMaxY() - 20;
    }

}
