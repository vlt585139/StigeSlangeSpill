package no.hvl.dat109.controller;

import java.util.ArrayList;
import java.util.List;

import java.util.Queue;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import no.hvl.dat109.model.Board;
import no.hvl.dat109.model.Piece;
import no.hvl.dat109.model.Square;
import no.hvl.dat109.service.GameUtility;
import no.hvl.dat109.service.StartupUtility;

/**
 * Controller for a game of snakes and ladders
 * 
 *
 */
@Controller
@RequestMapping("/game")
public class GameController {

	@Autowired
	private StartupUtility startupUtil;

	private GameUtility gameUtil = new GameUtility();

	/**
	 * Method to show the game board
	 * 
	 * Checks whether a game is currently active If its not currently active, aquire
	 * default board
	 * 
	 * @param session - HttpSession to contain a board
	 * @param request - HttpServletRequest to initiate session
	 * @return jsp view containing board
	 */
	@GetMapping
	public String showBoard(HttpServletRequest request) {

		if (!startupUtil.gameIsActive(request.getSession())) {
			return "redirect:start";
		}
		
		HttpSession session = request.getSession();
		Queue<Piece> queue = (Queue<Piece>) session.getAttribute("queue");

		if(queue.isEmpty()) {
			return "redirect:gameover";
		}
		
		return "gameView";
	}

	/**
	 * Method to execute a players turn
	 * 
	 * Rolls a dice Moves the piece based on number rolled Check the new position
	 * Depending on the check, move according to defined ruleset If a 6 was rolled -
	 * Increase the amount of 6 that were rolled in a row - If it reaches 3 in a
	 * row, move piece to start, and unable to restart before a 6 is rolled Else
	 * reset rolled in a row Check if game is won Adjust turns
	 * 
	 * @param request - HttpServletRequest containing the current session
	 * @return redirect to showBoard
	 */
	@PostMapping
	public String action(HttpServletRequest request) {
		
		HttpSession session = request.getSession();

		if (!startupUtil.gameIsActive(session)) {
			return "redirect:start";
		}

		Queue<Piece> queue = (Queue<Piece>) session.getAttribute("queue");
		Board board = new Board((List<List<Square>>) session.getAttribute("board"));
		Piece piece = queue.peek();

		int rolledValue = gameUtil.rollDice();

		gameUtil.move(rolledValue, piece, board);

		String currentSquareType = gameUtil.checkPosition(board, piece.getCurrentPos());

		if (currentSquareType.equals("snake") || currentSquareType.equals("ladder")) {
			gameUtil.move(board.findSquareByNumber(piece.getCurrentPos()).getToMove(), piece, board);
		}

		if (rolledValue == 6) {
			if (piece.getHasToRoll6()) {
				piece.setHasToRoll6(false);
			}
			piece.setRolled6InARow(piece.getRolled6InARow() + 1);
			if (piece.hasRolled6ThreeTimes()) {
				gameUtil.move(1 - piece.getCurrentPos(), piece, board);
				piece.setHasToRoll6(true);
			}
		}

		if (rolledValue != 6) {
			piece.setRolled6InARow(0);
			gameUtil.adjustTurn(session);
		}

		session.setAttribute("board", board.getBoard());

		return "redirect:game";
	}
}
