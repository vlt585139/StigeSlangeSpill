package no.hvl.dat109.service;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

import javax.servlet.http.HttpSession;

import no.hvl.dat109.model.Board;
import no.hvl.dat109.model.Piece;
import no.hvl.dat109.model.Square;

/**
 * 
 * @author Ivar
 * 
 *         Class that can be used to perform actions during a game of snakes and
 *         ladders
 *         
 */
public class GameUtility {

	/**
	 * Method that rolles a dice
	 * 
	 * @return int between 1 and 6
	 */
	public int rollDice() {

		Random random = new Random();
		int dice = random.nextInt(1, 6 + 1);

		return dice;
	}

	/**
	 * Moves a piece an amount of spaces
	 * 
	 * Checks whether the piece is allowed to move, will not go over 100 or under 1
	 * Gives the piece a new position if allowed to move
	 * 
	 * @param ValueToMove - int which indicates how far the piece has to move
	 * @param piece       - piece with information about current location
	 */
	public void move(int valueToMove, Piece piece, Board board) {
		int newPos = piece.getCurrentPos() + valueToMove;

		if (newPos <= 100 && newPos >= 1 && !(valueToMove != 6 && piece.getHasToRoll6())) {
			board.removePieceFromSquare(piece.getCurrentPos(), piece);
			piece.setCurrentPos(newPos);
			board.addPieceToSquare(newPos, piece);
		}

	}

	/**
	 * Method to check if in the current position a player has - Won the game -
	 * Landed at the bottom of a ladder - Landed on the top of a snake
	 * 
	 * @param board        - The active board
	 * @param squareNumber - The unique identifier of a square
	 * 
	 * @return One of four things - "game over" - Indicates the player has won the
	 *         game - "ladder" - Indicates the player is at the bottom of a ladder -
	 *         "snake" - Indicates the player is at the top of a snake - "clear" -
	 *         Indicates the player is on a blank space
	 */
	public String checkPosition(Board board, int squareNumber) {

		return board.findSquareByNumber(squareNumber).getSquareType();

	}

	/**
	 * Method that checks whether a 6 is rolled or not
	 * 
	 * @param value - value that has been rolled
	 * @return true if value is 6, else false
	 */
	public boolean hasRolled6(int value) {
		return value == 6;
	}

	/**
	 * Method to change turn
	 * 
	 * Remains the same if dice rolled 6, else changes to next player
	 * 
	 * @param session - HttpSession with definition of who's turn it currently is
	 */
	public void adjustTurn(HttpSession session) {
		Queue<Piece> queue = (Queue<Piece>) session.getAttribute("queue");
		Piece piece = queue.poll();
		if(piece.getCurrentPos() != 100) {
			queue.add(piece);
		}
		if(piece.getCurrentPos() == 100) {
			Queue<Piece> finished = (Queue<Piece>) session.getAttribute("finished");
			finished.add(piece);
			session.setAttribute("finished", finished);
		}
		session.setAttribute("queue", queue);
	}
}
