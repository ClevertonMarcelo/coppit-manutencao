package de.uni_mannheim.swt.pm_7.fdh.domain;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;

public class PersistenceData implements Serializable {

    private static final long serialVersionUID = -3396166019658450297L;

    private Point sourceClickPoint;
    private Point destinationClickPoint;
    private int dicedNumberOfTurn;
    private int gameSequenceNumber;
    private boolean gameIsFinished;
    private Color[] listOfPlayerColors;
    private String[] listOfPlayerNames;
    private boolean[] listOfIsComputerPlayer;

    public PersistenceData() {
        // Construtor vazio
    }

    public PersistenceData(Point source, Point destination, int dicedTurns, int sequenceNumber,
            boolean isFinished, boolean[] isComputerPlayer, String[] playerNames, Color[] playerColors) {
        this.sourceClickPoint = source;
        this.destinationClickPoint = destination;
        this.dicedNumberOfTurn = dicedTurns;
        this.gameSequenceNumber = sequenceNumber;
        this.gameIsFinished = isFinished;
        this.listOfPlayerColors = playerColors;
        this.listOfPlayerNames = playerNames;
        this.listOfIsComputerPlayer = isComputerPlayer;
    }

    public Color[] getPlayerColors() {
        return this.listOfPlayerColors;
    }

    public Point getDestinationClickPoint() {
        return this.destinationClickPoint;
    }

    public int getGameSequenceNumber() {
        return this.gameSequenceNumber;
    }

    public boolean[] getIsComputerPlayer() {
        return this.listOfIsComputerPlayer;
    }

    public String[] getPlayerNames() {
        return this.listOfPlayerNames;
    }

    public int getDicedNumberOfTurns() {
        return this.dicedNumberOfTurn;
    }

    public Point getSourceClickPoint() {
        return this.sourceClickPoint;
    }

    public boolean isGameFinished() {
        return this.gameIsFinished;
    }

    public void setPlayerColors(Color[] playerColors) {
        this.listOfPlayerColors = playerColors;
    }

    public void setDestinationClickPoint(Point destinationClickPoint) {
        this.destinationClickPoint = destinationClickPoint;
    }

    public void setGameFinished(boolean gameFinished) {
        this.gameIsFinished = gameFinished;
    }

    public void setGameSequenceNumber(int gameSequenceNumber) {
        this.gameSequenceNumber = gameSequenceNumber;
    }

    public void setIsComputerPlayer(boolean[] isComputerPlayer) {
        this.listOfIsComputerPlayer = isComputerPlayer;
    }

    public void setPlayerNames(String[] playerNames) {
        this.listOfPlayerNames = playerNames;
    }

    public void setDicedNumberOfTurns(int dicedNumberOfTurns) {
        this.dicedNumberOfTurn = dicedNumberOfTurns;
    }

    public void setSourceClickPoint(Point sourceClickPoint) {
        this.sourceClickPoint = sourceClickPoint;
    }

	public Point getSource() {
		return this.sourceClickPoint;
	}

	public Point getDest() {
		return this.destinationClickPoint;
	}
}