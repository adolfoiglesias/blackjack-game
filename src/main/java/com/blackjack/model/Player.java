/**
 * 
 */
package com.blackjack.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Adolfo Miguel Iglesias 
 *
 */

public class Player {
	
	private String name;
	
	private List<Card> cards;
	
	private StatusEnum status;
	
	private boolean dealer;
	
	private int score;
	
	public Player(String name, boolean dealer) {
		status = StatusEnum.ALLOW_MORE_CARD;
		cards = new ArrayList<Card>();
		this.name = name;
		this.dealer = dealer;
		
	}

	public boolean add(Card arg0) {
		return cards.add(arg0);
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public boolean hasCard() {
		return !this.cards.isEmpty();
	}

	public boolean isDealer() {
		return dealer;
	}

	public List<Card> getCards() {
		return cards;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public boolean isBusted() {
		return status.equals(StatusEnum.BUSTED);
	} 
	
	public boolean isAllowMoreCard() {
		return status.equals(StatusEnum.ALLOW_MORE_CARD);
	}
	
	
	@Override
	public String toString() {
		return name;
	}
}
