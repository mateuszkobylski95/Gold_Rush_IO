package edu.io;

import edu.io.token.EmptyToken;
import edu.io.token.Token;

public class Board {
    private final int size = 10;

    private Token[][] squares;

    public Board() {
        squares = new Token[size][size];
        clean();
    }

    public record Coords(int row, int col) {
    }

    public void clean() {
        Token emptyToken = new EmptyToken();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                squares[row][col] = emptyToken;
            }
        }
    }

    public void placeToken(int col, int row, Token token) {
        squares[row][col] = token;
    }
    public Token peekToken(int col, int row) {
        return squares[row][col];
    }


    public void display() {
        for (Token[] s : squares) {
            for (Token token : s) {
                System.out.print(token.label());
            }
            System.out.println();

        }
    }

    public int size() {
        return size;
    }

    public Board.Coords getAvailableSquare() throws IllegalStateException {
        for (int row = 0; row < size(); row++) {
            for (int col = 0; col < size(); col++) {
                if (peekToken(col, row) instanceof EmptyToken) return new Board.Coords(row, col);
            }
        }
        throw new IllegalStateException("Plansza zapełniona");
    }
}