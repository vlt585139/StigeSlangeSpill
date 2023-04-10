package no.hvl.dat109.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

class PieceTest {

	@Rule
	private TestRule globalTimeout = Timeout.seconds(10);
	
	private Piece piece = new Piece(1, 1);
	
	@Test
	void testRolled6ThreeTimes() {
		assertFalse(piece.hasRolled6ThreeTimes());
		
		piece.setRolled6InARow(3);
		
		assertTrue(piece.hasRolled6ThreeTimes());
		
		piece.setRolled6InARow(2);
		
		assertFalse(piece.hasRolled6ThreeTimes());
	}

}
