/**
 * 
 */
package com.blackjack.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import com.blackjack.model.AbstractRateCard;
import com.blackjack.model.BlackjackErrorCodeEnum;
import com.blackjack.model.Card;
import com.blackjack.model.CardTypeEnum;
import com.blackjack.model.Player;
import com.blackjack.util.BlackjackException;

/**
 * @author Adolfo Miguel Iglesias
 *
 */
public class DealerServiceImpl implements DealerService {
	
	
	/**
	 * get the next card randomly (card type and value)
	 */
	@Override
	public Card getNextCard(Set<Card> cards, List<AbstractRateCard> rateCards, List<CardTypeEnum> cardTypes) {
		
		Random random = new Random();
		int number = random.nextInt(rateCards.size());
		
		AbstractRateCard rateCard = rateCards.get(number);
		
		String name = rateCard.getCardName();
		Card card = new Card(name, cardTypes.get(random.nextInt(cardTypes.size())));
		card.setRateCard(rateCard);
		
		while(cards.contains(card)) {
			card = getNextCard(cards, rateCards, cardTypes);
			break;
		}
		return card;
	}
	
	@Override
	public Player getWinner(List<Player> players) {
		
		if(players.isEmpty() || players.stream().allMatch(p -> p.isBusted())) {
			throw new BlackjackException(BlackjackErrorCodeEnum.NO_WINNER);
		}
		
		List<Player> playersTemp = players.stream().filter(p -> !p.isBusted()).collect(Collectors.toList());
		
		Comparator<Player> comparator = (p1,p2) -> {
			
			if(p2.getScore() ==  p1.getScore() && p1.isDealer()) {
				return -1;
			}
			return Integer.compare(p2.getScore(), p1.getScore()); 
		};
		
		Collections.sort(playersTemp, comparator);
		
		validateTieBetweenNoDealerPlayer(playersTemp);
		
		return playersTemp.get(0);
		
	}
	
	private void validateTieBetweenNoDealerPlayer(List<Player> players ) {
		if(players.size() > 1) {
			
			if(!players.get(0).isDealer() && players.get(0).getScore() == players.get(1).getScore()) {
				throw new BlackjackException(BlackjackErrorCodeEnum.NO_WINNER);
			}   
		}
	}
		
	

}
