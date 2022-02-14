/**
 * 
 */
package com.blackjack.util;

import java.util.List;

import com.blackjack.model.BlackjackErrorCodeEnum;
import com.blackjack.model.Card;
import com.blackjack.model.Player;

/**
 * @author Adolfo Miguel Iglesias
 *
 */
public class GameValidator {
	
	public void validateNumberOfPlayer(int number) {
		if(number <= 0) {
			throw new BlackjackException(BlackjackErrorCodeEnum.INVALID_NUMBER_OF_PLAYER);
		}
	}
	
}
