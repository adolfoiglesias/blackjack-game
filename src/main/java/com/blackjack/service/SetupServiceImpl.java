/**
 * 
 */
package com.blackjack.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.blackjack.model.AbstractRateCard;
import com.blackjack.model.CardTypeEnum;
import com.blackjack.model.Player;
import com.blackjack.model.RateAceCard;
import com.blackjack.model.RateStandardCard;
import com.blackjack.util.GameUtil;
import com.blackjack.util.GameValidator;

/**
 * @author Adolfo Miguel Iglesias
 *
 */
public class SetupServiceImpl implements SetupService {
	
	private GameValidator gameValidator;
	
	public SetupServiceImpl() {
		gameValidator = new GameValidator();
	}
	
	@Override
	public List<Player> preparePlayers(int totalPlayer) {
		
		gameValidator.validateNumberOfPlayer(totalPlayer);
		
		List<Player> players  = new ArrayList<Player>();
		
		for (int i = 0; i < totalPlayer; i++) {
			players.add(new Player(String.valueOf(i+1), false));
		}
		players.add(new Player("Dealer", true));
		
		return players;
	}
	
	@Override
	public List<AbstractRateCard> getRateCards() {
		 List<AbstractRateCard> rateCards; rateCards = IntStream.range(1, 11).boxed()
				.map(n -> {
					return new RateStandardCard(String.valueOf(n), n);
				}).collect(Collectors.toList());
		
		rateCards.add(new RateStandardCard(GameUtil.getGetJ(), 10));
		rateCards.add(new RateStandardCard(GameUtil.getGetQ(), 10));
		rateCards.add(new RateStandardCard(GameUtil.getGetK(), 10));
		
		rateCards.add(new RateAceCard(GameUtil.getGetAce(), Arrays.asList(11, 1)));
		
		return rateCards;
	}
	
	@Override
	public List<CardTypeEnum> getCardTypeEnums() {
		return Arrays.asList(CardTypeEnum.CLUB, CardTypeEnum.DIAMOND, CardTypeEnum.HEART, CardTypeEnum.SPADE);
	}


}
