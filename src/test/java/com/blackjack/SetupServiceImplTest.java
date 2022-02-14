/**
 * 
 */
package com.blackjack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.blackjack.model.Player;
import com.blackjack.service.SetupService;
import com.blackjack.service.SetupServiceImpl;

/**
 * @author Adolfo Miguel Iglesias
 *
 */
public class SetupServiceImplTest {

	private static SetupService setupService;

	@BeforeAll
	static void setup() {
		setupService = new SetupServiceImpl();
	}

	@Test
	@DisplayName("Prepare 4 players, 3 user playes and 1 dealer payer")
	public void test_prepare3UserPlayersAndDealerPlayer() {

		List<Player> players = setupService.preparePlayers(3);

		assertEquals(4, players.size());
		assertEquals(1, players.stream().filter(p -> p.isDealer()).collect(Collectors.toList()).size());
	}

}
