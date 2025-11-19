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

    public record Coords(int col, int row) {
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

    }

    public int size() {
        return size;
    }

}