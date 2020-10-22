package org.acadmeiadecodigo.gnunas.keepitclean.characters;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.acadmeiadecodigo.gnunas.keepitclean.Level;
import org.acadmeiadecodigo.gnunas.keepitclean.objects.GameObject;
import org.acadmeiadecodigo.gnunas.keepitclean.Direction;
import org.acadmeiadecodigo.gnunas.keepitclean.objects.Interactable;
import java.util.Timer;
import java.util.TimerTask;

public class Player extends Character {

    private KeyboardPlayerHandler kbPlayerHandler;
    private Direction direction;
    Picture playerImage;
    private boolean movingUp = false;
    private boolean movingDown = false;
    private boolean movingLeft = false;
    private boolean movingRight = false;
    private boolean canMoveUp = true;
    private boolean canMoveDown = true;
    private boolean canMoveRight = true;
    private boolean canMoveLeft = true;
    private boolean interacting = false;
    public static int speed;
    private Level level;

    public Player(Level level) {
        playerImage = new Picture(500, 500, "resources/Character/CharacterFront.png");
        this.level = level;
        speed = 10;
        kbConfiguration();
        playerImage.draw();
    }

    public void kbConfiguration(){
        kbPlayerHandler = new KeyboardPlayerHandler(this,direction,PlayerKey.KEY.getUp(), PlayerKey.KEY.getDown(), PlayerKey.KEY.getLeft(), PlayerKey.KEY.getRight(), PlayerKey.KEY.getSpace(),PlayerKey.KEY.getQ());
        kbPlayerHandler.loadKboardConfig();
    }

    public void interact(GameObject gameObject){

        Timer timer = new Timer();

        Rectangle barOutline = new Rectangle(playerImage.getX() - 15 , playerImage.getY() - 30, 99, 20);
        Rectangle filler = new Rectangle(barOutline.getX() + 50 , barOutline.getY() + 1, 0, 19);
        barOutline.draw();
        filler.setColor(Color.RED);
        filler.fill();

        interacting = true;

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                filler.grow(1,0);

                if(filler.getX() <= barOutline.getX()) {
                    timer.cancel();
                    barOutline.delete();
                    filler.delete();
                    interacting = false;
                    ((Interactable) gameObject).interact();
                    bounce();
                    level.win();
                }
            }
        },0,100);
    }

    public void checkCollisions() {

        if(playerImage.getX()+10 <= level.getField().getBackground().getX()) {
            canMoveLeft = false;
        }

        if(playerImage.getMaxY() >= level.getField().getBackground().getMaxY()){
            canMoveDown = false;
        }

        if (playerImage.getY() <= level.getField().getBackground().getY() + 60) {
            canMoveUp = false;
        }

        if(playerImage.getMaxX()-10 >= level.getField().getBackground().getMaxX()){
            canMoveRight = false;
        }

        for (GameObject go : level.getField().getObjects()) {
            if((playerImage.getMaxX()-15 >= go.getX() && playerImage.getMaxY()-15 >= go.getY()) && (playerImage.getX()+15 <= go.getMaxX() && playerImage.getY()+40 <= go.getMaxY())) {
                //System.out.println("Collision " + go.toString());

                if(go instanceof Interactable) {
                    if (go.getName().equals("Poop")){
                        ((Interactable) go).interact();
                        go.delete();
                        level.getField().getObjects().remove(go);
                        level.win();
                        return;
                    }
                    if (go.getName().equals("Weed")){
                        ((Interactable) go).interact();
                        go.delete();
                        level.getField().getObjects().remove(go);
                        return;
                    }
                    if(!go.isClean()) {
                        interact(go);
                    }
                }

                bounce();

                canMoveUp = !movingUp;
                canMoveDown = !movingDown;
                canMoveRight = !movingRight;
                canMoveLeft = !movingLeft;
            }
        }
    }

    public void bounce(){
        //pequeno bounce para que nao continue a registar como collided
        if(movingUp){playerImage.translate(0,4);}
        if(movingDown){playerImage.translate(0,-4);}
        if(movingRight){playerImage.translate(-4,0);}
        if(movingLeft){playerImage.translate(4,0);}
    }

    public void checkMovement() {
        if (kbPlayerHandler.isMoving()) {
            move(chooseDirection());
        }
    }

    public Direction chooseDirection() {
        Direction nextDirection = kbPlayerHandler.getDirection();
        return nextDirection;
    }

    @Override
    public void move(Direction direction) {

        if (interacting){return;}

        checkCollisions();

        switch (direction) {
            case DOWN:
                if (canMoveDown) {
                    canMoveUp = true;
                    canMoveLeft = true;
                    canMoveRight = true;

                    movingDown = true;
                    movingUp = false;
                    movingRight = false;
                    movingLeft = false;
                    playerImage.translate(0, speed);
                    playerImage.load("resources/Character/CharacterFront.png");
                }
                break;

            case UP:
                if (canMoveUp) {
                    canMoveDown = true;
                    canMoveRight = true;
                    canMoveLeft = true;

                    movingDown = false;
                    movingUp = true;
                    movingRight = false;
                    movingLeft = false;
                    playerImage.translate(0, -speed);
                    playerImage.load("resources/Character/CharacterBack.png");
                }
                break;

            case RIGHT:
                if (canMoveRight) {
                    canMoveDown = true;
                    canMoveUp = true;
                    canMoveLeft = true;

                    movingDown = false;
                    movingUp = false;
                    movingRight = true;
                    movingLeft = false;
                    playerImage.translate(speed, 0);
                    playerImage.load("resources/Character/CharacterRight.png");
                }
                break;

            case LEFT:
                if (canMoveLeft) {
                    canMoveUp = true;
                    canMoveDown = true;
                    canMoveRight = true;

                    movingDown = false;
                    movingUp = false;
                    movingRight = false;
                    movingLeft = true;
                    playerImage.translate(-speed, 0);
                    playerImage.load("resources/Character/CharacterLeft.png");
                }
                break;
        }
    }

    public void setInteracting(boolean interacting) {
        this.interacting = interacting;
    }

    public boolean isInteracting() {
        return interacting;
    }
}