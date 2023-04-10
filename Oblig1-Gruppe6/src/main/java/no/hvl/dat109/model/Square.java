package no.hvl.dat109.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * @author Ivar
 *
 *         Class to represent a square in snakes and ladders
 * 
 *         Contains a unique square number, a square type, an amount of squares
 *         to move if the square is a ladder or snake and a list of pieces
 *         currently on the square
 *
 *
 */
@Entity
@Table(schema = "snakesandladders", name = "squares")
public class Square {

	@Id
	private int squarenumber;
	private String squaretype;
	private int tomove;
	
	@Transient
	private List<Piece> pieces;
	
	/**
	 * Default Constructor for JPA
	 */
	public Square() {
		
	}

	/**
	 * Constructor for Square
	 * 
	 * @param squareNumber - Unique number to identify the space
	 * @param squareType   - Which type of square the square is
	 * @param toMove       - Squares to move based on square type
	 * @param pieces       - List of the pieces currently in the square
	 */
	public Square(int squareNumber, String squareType, int toMove) {
		this.squarenumber = squareNumber;
		this.squaretype = squareType;
		this.tomove = toMove;
		this.pieces = pieces;
	}

	/**
	 * Method to get the unique square number
	 * 
	 * @return An int which identify the square
	 */

	public int getSquareNumber() {
		return squarenumber;
	}

	/**
	 * Method to set the unique square number
	 * 
	 * @param squareNumber - an unique int to identify the square
	 */
	public void setSquareNumber(int squareNumber) {
		this.squarenumber = squareNumber;
	}

	/**
	 * Method to get the square type
	 * 
	 * @return a String that tells what type of square it is
	 */
	public String getSquareType() {
		return squaretype;
	}

	/**
	 * Method to set the square type
	 * 
	 * @param squareType - a string that tells you what type of square it is
	 */
	public void setSquareType(String squareType) {
		this.squaretype = squareType;
	}

	/**
	 * Method to get the list of pieces in the square
	 * 
	 * @return a list of pieces currently in the square
	 */
	public List<Piece> getPieces() {
		return pieces;
	}

	/**
	 * Method to set the list of pieces in the square
	 * 
	 * @param pieces
	 */
	public void setPieces(List<Piece> pieces) {
		this.pieces = pieces;
	}

	/**
	 * Method to get the amount to move from this square
	 * 
	 * @return a number of squares to move
	 */
	public int getToMove() {
		return tomove;
	}

	/**
	 * Method to set the amount of squares to move from this square
	 * 
	 * @param toMove
	 */
	public void setToMove(int toMove) {
		this.tomove = toMove;
	}

}
