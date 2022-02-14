/**
 * 
 */
package com.blackjack.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.blackjack.model.AbstractRateCard;
import com.blackjack.model.BlackjackErrorCodeEnum;
import com.blackjack.model.Card;
import com.blackjack.model.CardTypeEnum;
import com.blackjack.model.Player;
import com.blackjack.model.StatusEnum;
import com.blackjack.util.BlackjackException;

/**
 * @author Adolfo Miguel Iglesias
 *
 */
public class BlackjackServiceImpl implements BlackjackService {
	

	private DealerService dealerService;

	private SetupService setupService;

	private Set<Card> cards;

	private List<Player> players;

	private List<AbstractRateCard> rateCards;

	private List<CardTypeEnum> cardTypes;

	private PlayerService userPlayerService;

	private PlayerService dealerPlayerService;

	@Override
	public List<Player> starGame() {

		players.forEach(p -> receiveCard(p));
		return players;
	}

	@Override
	public void setup(int number) {

		players = setupService.preparePlayers(number);
		rateCards = setupService.getRateCards();
		cardTypes = setupService.getCardTypeEnums();

		dealerPlayerService = new DealerPlayerServiceImpl(0.8);
		userPlayerService = new UserPlayerServiceImpl();
	}

	@Override
	public Player playCard(Player player) {

		receiveCard(player);

		PlayerService playerService = getPlayerService(player);
		playerService.allowOneMoreCard(player);

		return player;
	}

	private void receiveCard(Player player) {

		Card card = dealerService.getNextCard(cards, rateCards, cardTypes);
		addCard(card);
		player.add(card);
	}

	@Override
	public void setStand(Player player) {
		player.setStatus(StatusEnum.STAND);
	}

	@Override
	public Player getWinner() {
		return dealerService.getWinner(players);
	}

	public BlackjackServiceImpl() {
		super();
		cards = new HashSet<Card>();
		dealerService = new DealerServiceImpl();
		setupService = new SetupServiceImpl();
	}

	private void addCard(Card card) {
		if (!cards.add(card)) {
			throw new BlackjackException(BlackjackErrorCodeEnum.DUPLICATED_CARD);
		}
	}

	private PlayerService getPlayerService(Player player) {

		if (player.isDealer()) {
			return dealerPlayerService;
		} else {
			return userPlayerService;
		}
	}

}
