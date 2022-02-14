/**
 * 
 */
package com.blackjack.service;

import java.util.List;

import com.blackjack.model.AbstractRateCard;
import com.blackjack.model.CardTypeEnum;
import com.blackjack.model.Player;

/**
 * @author Adolfo Miguel Iglesias
 *
 */
public interface SetupService {
	
	public List<Player> preparePlayers(int totalPlayer);
	
	public List<AbstractRateCard> getRateCards();
	
	public List<CardTypeEnum> getCardTypeEnums();

}
