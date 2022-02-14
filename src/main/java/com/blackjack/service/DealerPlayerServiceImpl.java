/**
 * 
 */
package com.blackjack.service;

import com.blackjack.model.Player;
import com.blackjack.model.StatusEnum;
import com.blackjack.util.GameUtil;

/**
 * @author Adolfo Miguel Iglesias
 *
 */
public class DealerPlayerServiceImpl extends AbstractPlayerService {
	
	private double percentageToWin; 
		
	
	public DealerPlayerServiceImpl(double percentageToWin) {
		super();
		this.percentageToWin = percentageToWin;
	}


	@Override
	public StatusEnum allowOneMoreCard(Player player) {
		calculateScore(player);
		
		if(player.isDealer() && !player.isBusted()) {
			if(player.getScore() > GameUtil.getMaxScore() * percentageToWin) {
				player.setStatus(StatusEnum.STAND);
			}	
		}
		return player.getStatus();
	}
	

}
