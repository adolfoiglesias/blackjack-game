/**
 * 
 */
package com.blackjack;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.blackjack.model.AbstractRateCard;
import com.blackjack.model.Card;
import com.blackjack.model.CardTypeEnum;
import com.blackjack.model.Player;
import com.blackjack.model.RateAceCard;
import com.blackjack.model.RateStandardCard;
import com.blackjack.service.BlackjackService;
import com.blackjack.service.BlackjackServiceImpl;
import com.blackjack.util.GameUtil;

/**
 * @author Adolfo Miguel Iglesias
 *
 */
public class BlackjackServiceImplTest {
	
	private static BlackjackService blackjackService;
	
	@BeforeAll
	static void setup() {
		blackjackService = new BlackjackServiceImpl();
		blackjackService.setup(1);
	}
	
	@Test
	@DisplayName("Start game and all players with one card")
	public void test_starGameAllPlayerWithOneCard() {
		blackjackService.setup(2);
		List<Player> players = blackjackService.starGame();
		
		players.stream().forEach(p -> assertEquals(1, p.getCards().size()));
		
	}
		

}
