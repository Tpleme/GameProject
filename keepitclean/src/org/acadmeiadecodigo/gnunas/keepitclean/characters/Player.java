package org.acadmeiadecodigo.gnunas.keepitclean.characters;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.acadmeiadecodigo.gnunas.keepitclean.Level;
import org.acadmeiadecodigo.gnunas.keepitclean.objects.GameObject;
import org.acadmeiadecodigo.gnunas.keepitclean.Direction;


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

        init();
        kbConfiguration();

        // playerHandler();
    }


    public void kbConfiguration() {
        kbPlayerHandler = new KeyboardPlayerHandler(direction, PlayerKey.KEY.getUp(), PlayerKey.KEY.getDown(), PlayerKey.KEY.getLeft(), PlayerKey.KEY.getRight(), PlayerKey.KEY.getSpace());
        System.out.println("criado");
        kbPlayerHandler.loadKboardConfig();
    }


    public void init() {

        playerImage.draw();
    }

    public void checkCollisions() {

        if (playerImage.getX() <= level.getField().getBackground().getX()) {
            canMoveLeft = !movingLeft;
            System.out.println("Collision Left");
        }
        if (playerImage.getMaxY() >= level.getField().getBackground().getMaxY()) {
            canMoveDown = !movingDown;
            System.out.println("Collision Down");
        }
        if (playerImage.getY() <= level.getField().getBackground().getY() + 60) {
            System.out.println("Collision Top");
            canMoveUp = !movingUp;
        }
        if (playerImage.getMaxX() >= level.getField().getBackground().getMaxX()) {
            System.out.println("Collision Right");
            canMoveRight = !movingRight;
        }

        for (GameObject go : level.getField().getObjects()) {
            if ((playerImage.getMaxX() >= go.getX() && playerImage.getMaxY() >= go.getY()) && (playerImage.getX() <= go.getMaxX() && playerImage.getY() + 40 <= go.getMaxY())) {
                System.out.println("Collision " + go.toString());
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
        //
        // playerDirection = direction
        // field.moveDirection (direction,this)
        // field tem de ter a conversao para X,Y com os Translates lá.


        checkCollisions();

        switch (direction) {
            case DOWN -> {
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
            }
            case UP -> {
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
            }
            case RIGHT -> {
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
            }
            case LEFT -> {
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
            }

        }

    }

}