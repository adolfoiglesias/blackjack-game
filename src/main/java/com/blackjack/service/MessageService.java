/**
 * 
 */
package com.blackjack.service;

import com.blackjack.model.Player;
import com.blackjack.util.BlackjackException;

/**
 * @author Adolfo Miguel Iglesias
 *
 */
public interface MessageService {
	
	public String getDealingMessage(Player player, boolean inititalMessage);
	public String getDealingMessage(Player player);
	
	public String getWinnerMessage(Player player);
	
	public String getShufflingMessage();
	
	public String getStarGameMessage(int totalPlayers);
	
	public String getInvalidInitialCommandMessage();
	public String getInvalidCommandMessage();
	
	public String getNoWinnerMessage();
	
	public String getMessageFromException(BlackjackException exception);
	
	
	
}
