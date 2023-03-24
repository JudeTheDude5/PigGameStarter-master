package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

public class PigGameState extends GameState {

    private int playerTurn;

    private int player0Score;

    private int player1Score;

    private int dieValue;

    private int runningTotal;

    public PigGameState() {
        playerTurn = 0;
        player0Score = 0;
        player1Score = 0;
        dieValue = 1;
        runningTotal = 0;
    }

    public PigGameState(PigGameState p) {
        this.playerTurn = p.playerTurn;
        this.player0Score = p.player0Score;
        this.player1Score = p.player1Score;
        this.dieValue = p.dieValue;
        this.runningTotal = p.runningTotal;

    }

    public int turnGetter() {
        return playerTurn;
    }

    public int score0Getter() {
        return player0Score;
    }

    public int score1Getter() {
        return player1Score;
    }

    public int dieGetter() {
        return dieValue;
    }

    public int runningGetter() {
        return runningTotal;
    }

    public void turnSetter(int z) {
        playerTurn = z;
    }

    public void score0Setter(int z) {
        player0Score = z;
    }

    public void score1Setter(int z) {
        player1Score = z;
    }

    public void dieSetter(int z) {
        dieValue = z;
    }

    public void runningSetter(int z) {
        runningTotal = z;
    }

}
