/**
 * 
 */
package com.blackjack.model;

import java.util.stream.Collectors;

/**
 * @author Adolfo Miguel Iglesias
 *
 */
public class RateStandardCard extends AbstractRateCard {
	
	protected int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public RateStandardCard(String cardName, int value) {
		super(cardName);
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "RateStandardCard value: " + value;
	}
	
	
	
	
	

}
