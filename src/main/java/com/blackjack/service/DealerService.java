/**
 * 
 */
package com.blackjack.service;

import java.util.List;
import java.util.Set;

import com.blackjack.model.AbstractRateCard;
import com.blackjack.model.Card;
import com.blackjack.model.CardTypeEnum;
import com.blackjack.model.Player;

/**
 * @author Adolfo Miguel Iglesias
 *
 */
public interface DealerService {
	
	
	/**
	 * get the next card
	 * @param cards
	 * @return
	 */
	public Card getNextCard(Set<Card> cards, List<AbstractRateCard> rateCards, List<CardTypeEnum> cardTypes);
	
	
	/**
	 * Calculate the winner 
	 * @param players
	 * @return
	 */
	public Player getWinner(List<Player> players);

}
