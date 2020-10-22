package org.acadmeiadecodigo.gnunas.keepitclean.characters;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.acadmeiadecodigo.gnunas.keepitclean.Level;
import org.acadmeiadecodigo.gnunas.keepitclean.objects.GameObject;
import org.acadmeiadecodigo.gnunas.keepitclean.Direction;
import org.acadmeiadecodigo.gnunas.keepitclean.objects.Interactable;

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
    private Level level;

    public Player(Level level) {
        playerImage = new Picture(500, 500, "Character/CharacterFront.png");
        this.level = level;

        kbConfiguration();
        playerImage.draw();
    }

    public void kbConfiguration(){
        kbPlayerHandler = new KeyboardPlayerHandler(this,direction,PlayerKey.KEY.getUp(), PlayerKey.KEY.getDown(), PlayerKey.KEY.getLeft(), PlayerKey.KEY.getRight(), PlayerKey.KEY.getSpace(),PlayerKey.KEY.getQ());
        kbPlayerHandler.loadKboardConfig();
    }


    public void checkCollisions() {

        if(playerImage.getX()+10 <= level.getField().getBackground().getX()) {
            canMoveLeft = false;
            System.out.println("Collision Left");
        }

        if(playerImage.getMaxY() >= level.getField().getBackground().getMaxY()){
            System.out.println("Collision Down");
            canMoveDown = false;
        }

        if (playerImage.getY() <= level.getField().getBackground().getY() + 60) {
            System.out.println("Collision Top");
            canMoveUp = false;
        }

        if(playerImage.getMaxX()-10 >= level.getField().getBackground().getMaxX()){
            System.out.println("Collision Right");
            canMoveRight = false;
        }

        for (GameObject go : level.getField().getObjects()) {
            if((playerImage.getMaxX()-15 >= go.getX() && playerImage.getMaxY()-15 >= go.getY()) && (playerImage.getX()+15 <= go.getMaxX() && playerImage.getY()+40 <= go.getMaxY())) {
                System.out.println("Collision " + go.toString());

                if(go instanceof Interactable)
                    ((Interactable) go).interact();

                //pequeno bounce para que nao continue a registar como collided
                if(movingUp){playerImage.translate(0,2);}
                if(movingDown){playerImage.translate(0,-2);}
                if(movingRight){playerImage.translate(-2,0);}
                if(movingLeft){playerImage.translate(2,0);}

                canMoveUp = !movingUp;
                canMoveDown = !movingDown;
                canMoveRight = !movingRight;
                canMoveLeft = !movingLeft;

            }
        }
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
                    playerImage.translate(0, 10);
                    playerImage.load("Character/CharacterFront.png");
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
                    playerImage.translate(0, -10);
                    playerImage.load("Character/CharacterBack.png");
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
                    playerImage.translate(10, 0);
                    playerImage.load("Character/CharacterRight.png");
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
                    playerImage.translate(-10, 0);
                    playerImage.load("Character/CharacterLeft.png");
                }
                break;

        }

    }

}