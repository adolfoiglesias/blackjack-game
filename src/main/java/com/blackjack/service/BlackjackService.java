/**
 * 
 */
package com.blackjack.service;

import java.util.List;

import com.blackjack.model.Player;

/**
 * @author Adolfo Mguel Iglesias
 *
 */
public interface BlackjackService {
	
	/**
	 * Prepare all data necesary to star the game
	 * @param number
	 */
	public void setup(int number);
	
	/**
	 * Get next card and run the logic to know if the player can continue to play
	 * @param player
	 * @return
	 */
	public Player playCard(Player player);
	
	/**
	 * set stand status
	 * @param player
	 */
	public void setStand(Player player);
	
	/**
	 * star game, deliver inital card
	 * @return
	 */
	public List<Player> starGame();
	
	/**
	 * get the winner
	 * @return
	 */
	public Player getWinner();
	

}
