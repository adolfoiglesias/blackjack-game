/**
 * 
 */
package com.blackjack.model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Adolfo Miguel Iglesias
 *
 */
public class RateAceCard  extends AbstractRateCard {
	
	protected List<Integer> values;

	public List<Integer> getValues() {
		return values;
	}

	public void setValues(List<Integer> values) {
		this.values = values;
	}

	public RateAceCard(String cardName, List<Integer> values) {
		super(cardName);
		this.values = values;
	}

	@Override
	public String toString() {
		return "RateAceCard values: " + values.stream().map(v -> String.valueOf(v)).collect(Collectors.joining(", "));
	}
	
	
	

}
