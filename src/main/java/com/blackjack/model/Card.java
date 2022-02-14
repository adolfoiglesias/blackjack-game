/**
 * 
 */
package com.blackjack.model;

import com.blackjack.util.GameUtil;

/**
 * @author Adolfo Miguel Iglesias
 *
 */
public class Card {
	
	private String value;
	
	private CardTypeEnum cardTypeEnum;
	
	private AbstractRateCard rateCard;
	
	
	public Card(String value, CardTypeEnum cardTypeEnum) {
		this.value = value;
		this.cardTypeEnum = cardTypeEnum;
	}
	
	public CardTypeEnum getCardTypeEnum() {
		return cardTypeEnum;
	}
	public void setCardTypeEnum(CardTypeEnum cardTypeEnum) {
		this.cardTypeEnum = cardTypeEnum;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardTypeEnum == null) ? 0 : cardTypeEnum.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (cardTypeEnum != other.cardTypeEnum)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return (value.equalsIgnoreCase("ace") || value.equals("1")) 
				? String.format("%s %s", value,  cardTypeEnum.name())
				: String.format("%s %s", value,  cardTypeEnum.name() + "s");
	}
	
	public boolean isAce() {
		return this.value.equalsIgnoreCase(GameUtil.getGetAce());
	}

	public AbstractRateCard getRateCard() {
		return rateCard;
	}

	public void setRateCard(AbstractRateCard rateCard) {
		this.rateCard = rateCard;
	}
	
	

}
