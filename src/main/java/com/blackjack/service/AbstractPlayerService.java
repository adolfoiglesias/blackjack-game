/**
 * 
 */
package com.blackjack.service;

import java.util.List;
import java.util.stream.Collectors;

import com.blackjack.model.Card;
import com.blackjack.model.Player;
import com.blackjack.model.RateAceCard;
import com.blackjack.model.RateStandardCard;
import com.blackjack.model.StatusEnum;
import com.blackjack.util.GameUtil;

/**
 * @author Adolfo Miguel Iglesias
 *
 */
public abstract class AbstractPlayerService implements PlayerService {
	
	
	@Override
	public void calculateScore(Player player) {
		
		List<Card> cards = player.getCards();
		
		int subTotal = cards.stream().filter(c -> !c.isAce())
							.collect(Collectors.summingInt(c ->  ((RateStandardCard)c.getRateCard()).getValue()));
		
		player.setScore(subTotal);
		
		if(subTotal > GameUtil.getMaxScore()) {
			player.setStatus(StatusEnum.BUSTED);
			return;
		}
		
		List<Card> aceCards = cards.stream().filter(c -> c.isAce()).collect(Collectors.toList()); 
		
		// logic to calculate the score 
		for (int i = 0; i < aceCards.size(); i++) {
			
			subTotal+= getAceValue(subTotal, ((RateAceCard)aceCards.get(i).getRateCard()).getValues(), 0);
			player.setScore(subTotal);
			
			if(subTotal > GameUtil.getMaxScore()) {
				player.setStatus(StatusEnum.BUSTED);
				break;
			}
		}	
	}
	

	/**
	 * Acording to max value and the different ace values , this method choose the best option. 
	 * @param subTotal
	 * @param aceValues
	 * @param pos
	 * @return
	 */
	private int getAceValue(int subTotal, List<Integer> aceValues, int pos) {
		
		if(pos == aceValues.size()) {
			return aceValues.get(pos-1);
		}
		
		if(subTotal+ aceValues.get(pos) > GameUtil.getMaxScore())  {
			return getAceValue(subTotal, aceValues, ++pos);
		}
		
		return aceValues.get(pos);
	}
	

}
