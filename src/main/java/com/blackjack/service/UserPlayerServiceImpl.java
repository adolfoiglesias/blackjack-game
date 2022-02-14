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
public class UserPlayerServiceImpl extends AbstractPlayerService {
	
	@Override
	public StatusEnum allowOneMoreCard(Player player) {
		calculateScore(player);
		return player.getStatus();
	}

}
