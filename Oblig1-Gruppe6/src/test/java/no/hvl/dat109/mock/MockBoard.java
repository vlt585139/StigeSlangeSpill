package no.hvl.dat109.mock;

import java.util.ArrayList;
import java.util.List;

import no.hvl.dat109.model.Board;
import no.hvl.dat109.model.Piece;
import no.hvl.dat109.model.Square;

public class MockBoard {
	
	List<List<Square>> board = new ArrayList<List<Square>>(10);

	public MockBoard() {
		board = makeBoard();
	}
	
	public List<List<Square>> getBoard() {
		return board;
	}

	public List<List<Square>> makeBoard() {
		
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

		int number = 100;
		for (int i = 0; i < 10; i++) {
			row0.add(new Square(number, "clear", 0));
			number--;
		}

		number = 81;
		for (int i = 9; i >= 0; i--) {
			row1.add(new Square(number, "clear", 0));
			number++;
		}

		number = 80;
		for (int i = 0; i < 10; i++) {
			row2.add(new Square(number, "clear", 0));
			number--;
		}

		number = 61;
		for (int i = 9; i >= 0; i--) {
			row3.add(new Square(number, "clear", 0));
			number++;
		}

		number = 60;
		for (int i = 0; i < 10; i++) {
			row4.add(new Square(number, "clear", 0));
			number--;
		}

		number = 41;
		for (int i = 9; i >= 0; i--) {
			row5.add(new Square(number, "clear", 0));
			number++;
		}

		number = 40;
		for (int i = 0; i < 10; i++) {
			row6.add(new Square(number, "clear", 0));
			number--;
		}

		number = 21;
		for (int i = 9; i >= 0; i--) {
			row7.add(new Square(number, "clear", 0));
			number++;
		}

		number = 20;
		for (int i = 0; i < 10; i++) {
			row8.add(new Square(number, "clear", 0));
			number--;
		}

		number = 1;
		for (int i = 9; i >= 0; i--) {
			row9.add(new Square(number, "clear", 0));
			number++;
		}

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
		
		for(List<Square> row : board) {
			for(Square square : row) {
				square.setPieces(new ArrayList<Piece>());
			}
		}

		findSquareByNumber(81).setSquareType("ladder");
		findSquareByNumber(81).setToMove(18);

		findSquareByNumber(90).setSquareType("ladder");
		findSquareByNumber(90).setToMove(1);

		findSquareByNumber(51).setSquareType("ladder");
		findSquareByNumber(51).setToMove(16);

		findSquareByNumber(21).setSquareType("ladder");
		findSquareByNumber(21).setToMove(21);

		findSquareByNumber(27).setSquareType("ladder");
		findSquareByNumber(27).setToMove(57);

		findSquareByNumber(2).setSquareType("ladder");
		findSquareByNumber(2).setToMove(36);

		findSquareByNumber(4).setSquareType("ladder");
		findSquareByNumber(4).setToMove(11);

		findSquareByNumber(8).setSquareType("ladder");
		findSquareByNumber(8).setToMove(23);

		findSquareByNumber(98).setSquareType("snake");
		findSquareByNumber(98).setToMove(-34);

		findSquareByNumber(95).setSquareType("snake");
		findSquareByNumber(95).setToMove(-20);

		findSquareByNumber(92).setSquareType("snake");
		findSquareByNumber(92).setToMove(-4);

		findSquareByNumber(74).setSquareType("snake");
		findSquareByNumber(74).setToMove(-19);

		findSquareByNumber(68).setSquareType("snake");
		findSquareByNumber(68).setToMove(-3);

		findSquareByNumber(57).setSquareType("snake");
		findSquareByNumber(57).setToMove(-15);

		findSquareByNumber(41).setSquareType("snake");
		findSquareByNumber(41).setToMove(-38);

		findSquareByNumber(44).setSquareType("snake");
		findSquareByNumber(44).setToMove(-8);

		findSquareByNumber(47).setSquareType("snake");
		findSquareByNumber(47).setToMove(-25);

		findSquareByNumber(49).setSquareType("snake");
		findSquareByNumber(49).setToMove(-28);

		findSquareByNumber(16).setSquareType("snake");
		findSquareByNumber(16).setToMove(-11);

		findSquareByNumber(100).setSquareType("game over");

		return board;
	}
	
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

}
