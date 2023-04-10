package no.hvl.dat109.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import no.hvl.dat109.model.Board;
import no.hvl.dat109.model.Piece;
import no.hvl.dat109.model.Square;
import no.hvl.dat109.repo.BoardRepository;

/**
 * Class used to set-up a game of snakes and ladders
 * 
 * @author Ivar
 *
 */
@Service
public class StartupUtility {
	
	@Autowired
	private BoardRepository boardRepo;
	
	/**
	 * Creates a new game session, and adds a board, queue ... to the session
	 * 
	 * @param request     - The request that was sent
	 * @param playerCount - The amount of players selected
	 */
	public void createGameSession(HttpServletRequest request, int playerCount) {
		HttpSession session = request.getSession();

		Queue<Piece> queue = new LinkedBlockingQueue<Piece>(playerCount);
		Board board = new Board(makeBoard());

		for (int i = 0; i < playerCount; i++) {
			Piece piece = new Piece(1, i + 1);
			queue.add(piece);
			board.addPieceToSquare(1, piece);
		}

		session.setAttribute("queue", queue);
		session.setAttribute("board", board.getBoard());
		session.setAttribute("finished", new LinkedBlockingQueue<Piece>(playerCount));
	}
	
	public List<List<Square>> makeBoard() {

		List<Square> squares = boardRepo.findAll(); 
		squares.sort((a, b) -> a.getSquareNumber() - b.getSquareNumber());

		List<List<Square>> board = new ArrayList<List<Square>>(10);

		List<Square> row0 = new ArrayList<Square>();
		List<Square> row1 = new ArrayList<Square>();
		List<Square> row2 = new ArrayList<Square>();
		List<Square> row3 = new ArrayList<Square>();
		List<Square> row4 = new ArrayList<Square>();
		List<Square> row5 = new ArrayList<Square>();
		List<Square> row6 = new ArrayList<Square>();
		List<Square> row7 = new ArrayList<Square>();
		List<Square> row8 = new ArrayList<Square>();
		List<Square> row9 = new ArrayList<Square>();
		
		for(Square square : squares) {
			square.setPieces(new ArrayList<Piece>());
			if(square.getSquareNumber() <= 10) {
				row9.add(square);
			}
			if(square.getSquareNumber() <= 20 && square.getSquareNumber() > 10) {
				row8.add(square);
			}
			if(square.getSquareNumber() <= 30 && square.getSquareNumber() > 20) {
				row7.add(square);
			}
			if(square.getSquareNumber() <= 40 && square.getSquareNumber() > 30) {
				row6.add(square);
			}
			if(square.getSquareNumber() <= 50 && square.getSquareNumber() > 40) {
				row5.add(square);
			}
			if(square.getSquareNumber() <= 60 && square.getSquareNumber() > 50) {
				row4.add(square);
			}
			if(square.getSquareNumber() <= 70 && square.getSquareNumber() > 60) {
				row3.add(square);
			}
			if(square.getSquareNumber() <= 80 && square.getSquareNumber() > 70) {
				row2.add(square);
			}
			if(square.getSquareNumber() <= 90 && square.getSquareNumber() > 80) {
				row1.add(square);
			}
			if(square.getSquareNumber() <= 100 && square.getSquareNumber() > 90) {
				row0.add(square);
			}
		}
		
		Collections.reverse(row0);
		Collections.reverse(row2);
		Collections.reverse(row4);
		Collections.reverse(row6);
		Collections.reverse(row8);

		board.add(row0);
		board.add(row1);
		board.add(row2);
		board.add(row3);
		board.add(row4);
		board.add(row5);
		board.add(row6);
		board.add(row7);
		board.add(row8);
		board.add(row9);

		return board;
	}

	/**
	 * Method to check if a game session is active
	 * 
	 * @param session - The session that can be active
	 * @return - true if a game is active, else false
	 */
	public boolean gameIsActive(HttpSession session) {
		return (session != null && session.getAttribute("queue") != null && session.getAttribute("board") != null);
	}
	
}
