/**
 * 
 */
package com.blackjack.model;

/**
 * @author Adolfo Miguel Iglesias
 *
 */
public abstract class AbstractRateCard {
	
	protected String cardName;

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public AbstractRateCard(String cardName) {
		super();
		this.cardName = cardName;
	}
	
	
	

}
