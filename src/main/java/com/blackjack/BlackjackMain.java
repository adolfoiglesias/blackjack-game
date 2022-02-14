/**
 * 
 */
package com.blackjack;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.blackjack.model.BlackjackErrorCodeEnum;
import com.blackjack.model.Player;
import com.blackjack.model.StatusEnum;
import com.blackjack.service.BlackjackServiceImpl;
import com.blackjack.service.MessageService;
import com.blackjack.service.MessageServiceImpl;
import com.blackjack.util.BlackjackException;

/**
 * @author Adolfo Miguel Iglesias
 *
 */
public class BlackjackMain {

	private static final String REGEX = "blackjack \\d";

	private static final String STAND_COMMAND = "stand";
	private static final String HIT_COMMAND = "hit";

	private static BlackjackServiceImpl blackjackManager = new BlackjackServiceImpl();
	private static MessageService messageService = new MessageServiceImpl();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		if (args.length != 2) {
			printMessage(messageService.getInvalidInitialCommandMessage());
			System.exit(0);
		}

		String commandLine = args[0] + " " + args[1];

		if (!commandLine.matches(REGEX)) {
			printMessage(messageService.getInvalidInitialCommandMessage());
			System.exit(0);
		}

		// start game
		int totalPlayers = Integer.valueOf(args[1]);

		try {

			blackjackManager.setup(totalPlayers);

			printMessage(messageService.getStarGameMessage(totalPlayers));
			printMessage(messageService.getShufflingMessage());

			// ----------------------------- start game
			List<Player> players = blackjackManager.starGame();
			players.forEach(p -> printMessage(messageService.getDealingMessage(p, true)));

			// -------------------------- deliver card to Users
			deliverCardToUser(players.stream().filter(p -> !p.isDealer()).collect(Collectors.toList()));

			// -------------------------  deliver card to Dealer
			deliverCardToDealer(players.stream().filter(p -> p.isDealer()).findAny().get());

			Player player = blackjackManager.getWinner();
			printMessage(messageService.getWinnerMessage(player));

		} catch (BlackjackException exception) {
			
			if (exception.getCode() == BlackjackErrorCodeEnum.NO_WINNER.getCode()) {
				printMessage(messageService.getNoWinnerMessage());
			} else {
				printMessage(messageService.getMessageFromException(exception));
			}
		}

	}

	private static boolean isStandOrHitCommand(String value) {
		if (value == null) {
			return false;
		}
		value = value.trim().toLowerCase();
		return value.equalsIgnoreCase(HIT_COMMAND) || value.equalsIgnoreCase(STAND_COMMAND);
	}

	
	private static void deliverCardToDealer(Player player) {
		
		player = blackjackManager.playCard(player);
		
		printMessage(messageService.getDealingMessage(player));
		
		if (player.getStatus().equals(StatusEnum.ALLOW_MORE_CARD)) {
			deliverCardToDealer(player);
		}
		return;
	}
	
	
	private static void deliverCardToUser(List<Player> players) {

		Scanner scanner = new Scanner(System.in);

		for (Player player : players) {

			// ------- second deliver round
			player = blackjackManager.playCard(player);
			String message = messageService.getDealingMessage(player);
			printMessage(message);
			
			if (player.getStatus().equals(StatusEnum.BUSTED)) {
				continue;
			}

			while (scanner.hasNextLine()) {

				String commandValue = scanner.nextLine().trim();

				if (!isStandOrHitCommand(commandValue)) {
					printMessage(messageService.getInvalidCommandMessage());
					continue;
				}

				if (commandValue.equalsIgnoreCase("stand")) {
					// jump to another player
					blackjackManager.setStand(player);
					break;
				}

				if (commandValue.equalsIgnoreCase("hit")) {
					
					player = blackjackManager.playCard(player);
					printMessage(messageService.getDealingMessage(player));

					if (player.getStatus().equals(StatusEnum.BUSTED)) {
						break;
					}
				}
			}
		}

		scanner.close();
	}
	
	private static void printMessage(String message) {
		System.out.println(message);
	}

}
