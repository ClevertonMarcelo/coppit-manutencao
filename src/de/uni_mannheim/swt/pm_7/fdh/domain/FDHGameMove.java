/*
 * Copyright (C) 2010  Denny Stohr - University of Mannheim
 */
package de.uni_mannheim.swt.pm_7.fdh.domain;

import java.util.Observable;

// TODO: Auto-generated Javadoc
/**
 * The Class FDHGame.
 */
@SuppressWarnings("deprecation")
public class FDHGameMove extends Observable {

	private FDHGame fdhGame;

	/**
	 * Instantiates a new fDH game.
	 */
	public FDHGameMove() {
		super();
		this.fdhGame = new FDHGame();
	}

	
	/**
	 * Legalmove.
	 *
	 * @param s the s
	 * @param h the h
	 * @return true, if successful
	 */
	public boolean legalmove(Field s, Hat h) {
		if (s.isWaitField()) {
			if (s.getHads().size() > 3) {
				return false;
			}
		}
		if (s.isHouse()) {
			if ((s.getColor() != h.getHadColor())
					|| ((s.getColor() == h.getHadColor()) && (h.getCatchedNum() == 0))) {
				return false;
			}
		}
		return true;

	}

}
