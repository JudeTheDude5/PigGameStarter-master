package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import java.util.Random;

// dummy comment, to see if commit and push work from srvegdahl account

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    private PigGameState ugh;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        //TODO  You will implement this constructor
        this.ugh = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this method
        if(ugh.turnGetter() == playerIdx) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method
        if(action instanceof PigHoldAction) {
            if(ugh.turnGetter() == 0) {
                ugh.score0Setter(ugh.score0Getter() + ugh.runningGetter());
                ugh.runningSetter(0);
                ugh.turnSetter(1);
                return true;
            }
            else {
                ugh.score1Setter(ugh.score1Getter() + ugh.runningGetter());
                ugh.runningSetter(0);
                ugh.turnSetter(0);
                return true;
            }
        }
        if(action instanceof PigRollAction) {
            //Makes Random Number 0-5
            Random die = new Random();
            int dieRoller = die.nextInt(6);
            ugh.dieSetter(dieRoller);

            //Sets running total to 0 if 0, adds die roll plus 1 if 1-5
            if(dieRoller == 0) {
                ugh.runningSetter(0);

                if(ugh.turnGetter() == 0) {
                    ugh.turnSetter(1);
                }
                else {
                    ugh.turnSetter(0);
                }
            }
            else {
                ugh.runningSetter(ugh.runningGetter() + dieRoller + 1);
            }

            return true;
        }
        return false;

    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method

        PigGameState copy = new PigGameState(this.ugh);
        p.sendInfo(copy);

    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        String win = null;
        if(ugh.score0Getter() >= 50) {
            win = "Wooh player 0 won with a score of " + ugh.score0Getter();
        }
        else if(ugh.score1Getter() >= 50) {
            win = "Wooh player 1 won with a score of " + ugh.score1Getter();
        }
        return win;
    }

}// class PigLocalGame
