package no.hvl.dat109.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.springframework.beans.factory.annotation.Autowired;

import no.hvl.dat109.mock.MockBoard;
import no.hvl.dat109.service.StartupUtility;

class BoardTest {

	@Rule
	private TestRule globalTimeout = Timeout.seconds(10);
	
	private MockBoard mockBoard = new MockBoard();
	
	private Board board = new Board(mockBoard.getBoard());

	@Test
	void findsCorrectSquare() {
		Square s = board.findSquareByNumber(94);

		assertFalse(s == null);
		assertEquals(s.getSquareNumber(), 94);
	}

	@Test
	void pieceGetsAddedToSquare() {
		Piece p = new Piece(1, 1);

		board.addPieceToSquare(91, p);

		Square s = board.findSquareByNumber(91);

		assertEquals(s.getPieces().size(), 1);
		assertTrue(s.getPieces().contains(p));
	}

	@Test
	void pieceGetsRemovedFromSquare() {
		Piece p = new Piece(1, 1);

		board.addPieceToSquare(91, p);
		board.removePieceFromSquare(91, p);
		
		Square s = board.findSquareByNumber(91);
		
		assertTrue(s.getPieces().isEmpty());
	}
}
