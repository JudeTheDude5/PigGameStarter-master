package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

public class SmartComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public SmartComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        // TODO  You will implement this method
        PigGameState recieve = new PigGameState((PigGameState)info);
        Random q = new Random();
        int z = q.nextInt(2);

        try {
            Thread.sleep(1000);
            if(recieve.turnGetter() != this.playerNum) {
                return;
            }
            else {
                if(z == 0) {
                    PigHoldAction play = new PigHoldAction(this);
                    game.sendAction(play);
                    //Thread.sleep(1000);
                }
                else {
                    PigRollAction play = new PigRollAction(this);
                    game.sendAction(play);
                    //Thread.sleep(1000);
                }
            }

        }
        catch (Exception e) {

        }
    }//receiveInfo
}
