/**
 * 
 */
package com.blackjack.model;

/**
 * @author Adolfo Miguel Iglesias
 *
 */
public enum BlackjackErrorCodeEnum {
	
	INVALID_NUMBER_OF_PLAYER(1, "Total of player must be grater than 0"),
	
	DUPLICATED_CARD(2, "Card duplicated"),
	MISS_ONE_CARD(3, "At least the player should have one card"),
	NO_MORE_PLAYER_WITHOUT_CARD(4, "There is no more player without card"),
	NO_WINNER(5, "There is no winner"),
	INVALID_PLAYER_POS(6, "Invalid player position");
	
	private int code;
	private String message;
	
	BlackjackErrorCodeEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
