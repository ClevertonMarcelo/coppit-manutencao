package de.uni_mannheim.swt.pm_7.fdh.domain;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The ComputerPlayer class represents a computer player in a game.
 */
public class ComputerPlayer {

    private Hat currentHat;
    private Field currentField;

    /**
     * Instantiates a new computer player.
     */
    public ComputerPlayer() {
    }

    /**
     * Chooses a hat from the available players' hats.
     *
     * @param playersHats the players' hats
     */
    public void chooseHat(List<Hat> playersHats) {
        currentHat = playersHats.get(new Random().nextInt(playersHats.size()));
        for (Hat hat : playersHats) {
            if (hat.hasCatched()) {
                currentHat = hat;
            }
        }
        currentField = currentHat.getField();
        currentHat.setSourcePos((Point) currentHat.getPosition());
    }

    /**
     * Gets the current field.
     *
     * @return the current field
     */
    public Field getCurrentField() {
        return currentField;
    }

    /**
     * Gets the current hat.
     *
     * @return the current hat
     */
    public Hat getCurrentHat() {
        return currentHat;
    }

    public Field getDestField(ArrayList<Field> legal) {
		if (this.currentHat.hasCatched()) {
			for (Field f : legal) {
				if (f.isHouse()
						&& (f.getColor() == this.currentHat.getHadColor())) {
					return f;
				}
			}
		} else {
			for (Field f : legal) {
				if ((f.getHads().size() > 0)
						&& (f.getColor() != this.currentHat.getHadColor())) {
					return f;
				}
			}
		}

		return legal.get((int) (Math.random() * legal.size()));
	}
}