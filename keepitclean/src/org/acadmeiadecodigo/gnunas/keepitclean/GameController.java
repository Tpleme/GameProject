package org.acadmeiadecodigo.gnunas.keepitclean;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class GameController implements KeyboardHandler {

    Keyboard gameController ;

    public GameController() {
        gameController = new Keyboard(this);
        loadKboardConfig();


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if(Game.currentState != GameState.PLAYING) {

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {

                Game.currentOption = Game.currentOption == Game.SelectedOption.QUIT ? Game.SelectedOption.INSTRUCTIONS : Game.SelectedOption.PLAY;

            }
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {

                Game.currentOption = Game.currentOption == Game.SelectedOption.PLAY ? Game.SelectedOption.INSTRUCTIONS : Game.SelectedOption.QUIT;

            }
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {

                if (Game.currentOption == Game.SelectedOption.QUIT){
                    Game.exit();
                }

                if(Game.currentOption == Game.SelectedOption.INSTRUCTIONS){
                    // fazer aparecer instruções

                    Game.currentState = GameState.INSTRUCTIONS;

                }

                if (Game.currentOption == Game.SelectedOption.PLAY) {

                        Game.currentState = GameState.PLAYING;


                }


            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


    public void loadKboardConfig(){

        KeyboardEvent pressedUp = new KeyboardEvent();
        pressedUp.setKey(KeyboardEvent.KEY_UP);
        pressedUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        gameController.addEventListener(pressedUp);


        KeyboardEvent pressedDown = new KeyboardEvent();
        pressedDown.setKey(KeyboardEvent.KEY_DOWN);
        pressedDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        gameController.addEventListener(pressedDown);


        KeyboardEvent pressedSpace = new KeyboardEvent();
        pressedSpace.setKey(KeyboardEvent.KEY_SPACE);
        pressedSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        gameController.addEventListener(pressedSpace);


    }
}
