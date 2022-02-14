/**
 * 
 */
package com.blackjack;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.blackjack.model.AbstractRateCard;
import com.blackjack.model.BlackjackErrorCodeEnum;
import com.blackjack.model.Card;
import com.blackjack.model.CardTypeEnum;
import com.blackjack.model.Player;
import com.blackjack.model.RateAceCard;
import com.blackjack.model.RateStandardCard;
import com.blackjack.model.StatusEnum;
import com.blackjack.service.DealerService;
import com.blackjack.service.DealerServiceImpl;
import com.blackjack.service.SetupService;
import com.blackjack.service.SetupServiceImpl;
import com.blackjack.util.BlackjackException;

/**
 * @author amich
 *
 */
public class DealerServiceImplTest {
	
	private static DealerService dealerService;
	
	private static SetupService setupService;
	
	private static List<AbstractRateCard> rateCards;
	
	private static List<CardTypeEnum> cardTypes;
	
	@BeforeAll
	static void setup() {
		dealerService = new DealerServiceImpl();
		setupService = new SetupServiceImpl();
		
		rateCards = setupService.getRateCards();
		cardTypes = setupService.getCardTypeEnums();
	}
	
	@Test
	@DisplayName("Geting next card correctly")
	public void test_getNextCard() {
		
		Set<Card> cards = new HashSet<Card>();
		
		for (int i = 0; i < 50; i++) {
			
			Card card1 = dealerService.getNextCard(cards, rateCards, cardTypes);
			
			boolean inserted = cards.add(card1);
			
			assertNotNull(card1);
			assertTrue(inserted);
			
			if(card1.isAce()) {
				assertEquals(RateAceCard.class, card1.getRateCard().getClass());
			} else {
				
				assertEquals(RateStandardCard.class, card1.getRateCard().getClass());
			}
		}
	}
	
	
	@Test
	@DisplayName("Player 1 is the winner")
	public void test_getWinnerPlayer1() {
		
		Player p1 = new Player("1", false);
		p1.setScore(21);
		
		Player p2 = new Player("2", false);
		p2.setScore(12);
		
		Player p3 = new Player("3", false);
		p3.setScore(2);
		
		
		Player player = dealerService.getWinner(Arrays.asList(p2,p1,p3));
		
		assertEquals(p1.getName(), player.getName());
		assertEquals(p1.getScore(), player.getScore());
		
	}
	
	@Test
	@DisplayName("Player dealer is the winner due to tied game")
	public void test_getWinnerPlayerDealerDueToTiedGame() {
		
		
		Player p1 = new Player("1", false);
		p1.setScore(21);
		
		Player p2 = new Player("2", false);
		p2.setScore(12);
		
		Player p3 = new Player("3", true);
		p3.setScore(21);
		
		Player player = dealerService.getWinner(Arrays.asList(p2,p1,p3));
		
		assertEquals(p3.getName(), player.getName());
		assertEquals(p3.getScore(), player.getScore());
		
	}
	
	@Test
	@DisplayName("No winner due to all player are busted")
	public void test_getNoWinnerDueToBustedPlayer() {
		
		
		Player p1 = new Player("1", false);
		p1.setStatus(StatusEnum.BUSTED);
		
		Player p2 = new Player("2", false);
		p2.setStatus(StatusEnum.BUSTED);
		
		Throwable exception = assertThrows(BlackjackException.class, () -> {
			dealerService.getWinner(Arrays.asList(p2,p1));
	    });
		
		assertEquals(((BlackjackException)exception)
	    		.getCode(), BlackjackErrorCodeEnum.NO_WINNER.getCode());
		
	}
	

}
