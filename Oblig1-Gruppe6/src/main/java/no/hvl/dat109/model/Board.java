package no.hvl.dat109.model;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author Ivar
 *
 *         Class that defines a board in snakes and ladders
 */
public class Board {

	private List<List<Square>> board;

	public Board(List<List<Square>> board) {
		this.board = board;
	}

	/**
	 * Method to get the board
	 * 
	 * @return the board
	 */
	public List<List<Square>> getBoard() {
		return board;
	}

	/**
	 * Method to set the board
	 * 
	 * @param board - A board we want to set
	 */
	public void setBoard(List<List<Square>> board) {
		this.board = board;
	}

	/**
	 * Method that finds a square by its square number
	 * 
	 * @param number - The identifier of the square you are looking for
	 * @return - The Square we are looking for
	 */
	public Square findSquareByNumber(int number) {
		for (List<Square> row : board) {
			for (Square square : row) {
				if (square.getSquareNumber() == number) {
					return square;
				}
			}
		}
		return null;
	}

	/**
	 * Method to add a piece onto a square
	 * 
	 * @param number - Identidier of a square
	 * @param piece  - The piece you want to add
	 */
	public void addPieceToSquare(int number, Piece piece) {
		Square square = findSquareByNumber(number);

		List<Piece> pieces = square.getPieces();
		pieces.add(piece);
		square.setPieces(pieces);
	}

	/**
	 * Method to remove a piece from a square
	 * 
	 * @param number - Identifier of a square
	 * @param piece  - The piece you want to add
	 */
	public void removePieceFromSquare(int number, Piece piece) {
		Square square = findSquareByNumber(number);

		List<Piece> pieces = square.getPieces();
		pieces.remove(piece);
		square.setPieces(pieces);
	}

}
