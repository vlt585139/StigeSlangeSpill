package no.hvl.dat109.utility;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import javax.servlet.http.HttpSession;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.springframework.beans.factory.annotation.Autowired;

import no.hvl.dat109.mock.MockBoard;
import no.hvl.dat109.model.Board;
import no.hvl.dat109.model.Piece;
import no.hvl.dat109.model.Square;
import no.hvl.dat109.service.GameUtility;
import no.hvl.dat109.service.StartupUtility;

class GameUtilityTest {

	@Rule
	private TestRule globalTimeout = Timeout.seconds(10);

	private GameUtility gameUtil = new GameUtility();
	
	private MockBoard mockBoard = new MockBoard();

	@Test
	void allRolledValuesAreWithinRange() {

		for (int i = 0; i < 100000; i++) {
			int rolled = gameUtil.rollDice();
			assertTrue(1 <= rolled && 6 >= rolled);
		}

	}

	@Test
	void diceIsFair() {

		int rolled1 = 0;
		int rolled2 = 0;
		int rolled3 = 0;
		int rolled4 = 0;
		int rolled5 = 0;
		int rolled6 = 0;

		for (int i = 0; i < 1000000; i++) {
			int rolledValue = gameUtil.rollDice();
			if (rolledValue == 1) {
				rolled1++;
			}
			if (rolledValue == 2) {
				rolled2++;
			}
			if (rolledValue == 3) {
				rolled3++;
			}
			if (rolledValue == 4) {
				rolled4++;
			}
			if (rolledValue == 5) {
				rolled5++;
			}
			if (rolledValue == 6) {
				rolled6++;
			}
		}
		double rolled1Percent = (rolled1 * 100) / 1000000;
		double rolled2Percent = (rolled2 * 100) / 1000000;
		double rolled3Percent = (rolled3 * 100) / 1000000;
		double rolled4Percent = (rolled4 * 100) / 1000000;
		double rolled5Percent = (rolled5 * 100) / 1000000;
		double rolled6Percent = (rolled6 * 100) / 1000000;

		assertTrue(rolled1Percent >= 14.6 && rolled1Percent <= 19.2);
		assertTrue(rolled2Percent >= 14.6 && rolled2Percent <= 19.2);
		assertTrue(rolled3Percent >= 14.6 && rolled3Percent <= 19.2);
		assertTrue(rolled4Percent >= 14.6 && rolled4Percent <= 19.2);
		assertTrue(rolled5Percent >= 14.6 && rolled5Percent <= 19.2);
		assertTrue(rolled6Percent >= 14.6 && rolled6Percent <= 19.2);
	}

	@Test
	void newPositionIsCorrect() {

		Piece p = new Piece(10, 1);
		
		Board board = new Board(mockBoard.getBoard());

		int rolled = gameUtil.rollDice();

		gameUtil.move(rolled, p, board);

		assertEquals(p.getCurrentPos(), 10 + rolled);

	}

	@Test
	void doesNotMovePastFinish() {

		Piece p = new Piece(99, 1);
		
		Board board = new Board(mockBoard.getBoard());

		int rolled = 3;

		gameUtil.move(rolled, p, board);

		assertEquals(p.getCurrentPos(), 99);
	}

	@Test
	void hasRolled6Test() {

		assertFalse(gameUtil.hasRolled6(1));
		assertFalse(gameUtil.hasRolled6(2));
		assertFalse(gameUtil.hasRolled6(3));
		assertFalse(gameUtil.hasRolled6(4));
		assertFalse(gameUtil.hasRolled6(5));

		assertTrue(gameUtil.hasRolled6(6));
	}

	@Test
	void testCheckPosition() {
		Board board = new Board(mockBoard.getBoard());

		assertEquals("game over", gameUtil.checkPosition(board, 100));
		assertEquals("ladder", gameUtil.checkPosition(board, 2));
		assertEquals("snake", gameUtil.checkPosition(board, 41));
		assertEquals("clear", gameUtil.checkPosition(board, 10));

	}
	
	@Test
	void testAdjustTurn() {
		HttpSession session = mock(HttpSession.class);
		
		Piece piece1 = new Piece(1, 1);
		Piece piece2 = new Piece(1, 2);
		
		Queue<Piece> queue = new ArrayBlockingQueue<Piece>(2);
		queue.add(piece1);
		queue.add(piece2);
		
		when(session.getAttribute("queue")).thenReturn(queue);
		
		gameUtil.adjustTurn(session);
		queue = (Queue) session.getAttribute("queue");
		
		assertEquals(piece2, queue.poll());
		assertEquals(piece1, queue.poll());
		assertTrue(queue.isEmpty());
	}

}
