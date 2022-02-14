/**
 * 
 */
package com.blackjack.service;

import com.blackjack.model.Player;
import com.blackjack.model.StatusEnum;

/**
 * @author Adolfo Miguel Iglesias
 *
 */
public interface PlayerService {
	
	/**
	 * Calculates the score, according to cards the player has.
	 * @param player
	 */
	public void calculateScore(Player player );
	
	/**
	 * Analyze if the player should receive one more card or not or busted
	 * @return
	 */
	public StatusEnum allowOneMoreCard(Player player);
	

}
