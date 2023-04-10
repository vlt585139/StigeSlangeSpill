package no.hvl.dat109.model;

/**
 * 
 * @author Ivar
 * 
 *         Class to represent a piece in a game of snakes and ladders
 * 
 *         Contains values for current position and which player is controlling
 *         the piece
 *
 */
public class Piece {

	private int currentPos;
	private int playerNumber;
	private int rolled6InARow;
	private boolean hasToRoll6;

	/**
	 * Constructor for piece
	 * 
	 * @param currentPos   - current square indicated with a number
	 * @param playerNumber - player indicated with a number 1-4
	 */
	public Piece(int currentPos, int playerNumber) {
		super();
		this.currentPos = currentPos;
		this.playerNumber = playerNumber;
		rolled6InARow = 0;
		hasToRoll6 = false;
	}

	/**
	 * Method to get the current position value
	 * 
	 * @return An int indicating the current position
	 */
	public int getCurrentPos() {
		return currentPos;
	}

	/**
	 * Method to set the current position value
	 * 
	 * @param currentPos - int for what the new position is
	 */
	public void setCurrentPos(int currentPos) {
		this.currentPos = currentPos;
	}

	/**
	 * Method to get which player owns the piece
	 * 
	 * @return - An int indicating which player owns the piece
	 */
	public int getPlayerNumber() {
		return playerNumber;
	}

	/**
	 * Method to set which player owns the piece
	 * 
	 * @param playerNumber - player indicated by a number
	 */
	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	/**
	 * Method to get how many 6 rolled in a row
	 * 
	 * @return An int representing 6 in a row
	 */
	public int getRolled6InARow() {
		return rolled6InARow;
	}

	/**
	 * Method to set the amount of 6 rolled in a row
	 * 
	 * @param rolled6_3InARow - int with how many 6 in a row
	 */
	public void setRolled6InARow(int rolled6_3InARow) {
		this.rolled6InARow = rolled6_3InARow;
	}

	/**
	 * Method to check if a 6 is needed
	 * 
	 * @return true if you need to roll 6, else false
	 */
	public boolean getHasToRoll6() {
		return hasToRoll6;
	}

	/**
	 * Method to set if a 6 needs to be rolled
	 * 
	 * @param hasToRoll6 - boolean
	 */
	public void setHasToRoll6(boolean hasToRoll6) {
		this.hasToRoll6 = hasToRoll6;
	}

	/**
	 * Method that checks if you have rolled 6 3 times in a row
	 * 
	 * @return true if rolled 6 3 times, else false
	 */
	public boolean hasRolled6ThreeTimes() {

		return rolled6InARow == 3;

	}

}
