/**
 * 
 */
package com.blackjack.util;

import com.blackjack.model.BlackjackErrorCodeEnum;

/**
 * @author Adolfo Miguel Iglesias
 *
 */
public class BlackjackException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int code;

	public BlackjackException(int code, String message) {
		super(message);
		this.code = code;
	}
	
	public BlackjackException(BlackjackErrorCodeEnum blackjackErrorCodeEnum) {
		super(blackjackErrorCodeEnum.getMessage());
		this.code = blackjackErrorCodeEnum.getCode();
	}

	public int getCode() {
		return code;
	}
	
	

}
