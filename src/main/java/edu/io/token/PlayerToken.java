package edu.io.token;

import edu.io.Board;

public class PlayerToken extends Token {
    private final Board board;
    private int col;
    private int row;

    // Definicje ruchów wymagane przez PlayerToken
    public enum Move {
        NONE, UP, DOWN, LEFT, RIGHT
    }

    // Wymagane przez TokenTest.test_PlayerToken_label
    @Override
    public String label() {
        return Label.PLAYER_TOKEN_LABEL;
    }

    // Wymagane przez PlayerTest.new_PlayerToken_is_placed_on_the_board
    public PlayerToken(Board board) {
        this.board = board;
        // Ustawienie początkowej pozycji na (0, 0)
        this.col = 0; 
        this.row = 0;
        // Umieszczenie tokenu na planszy przy tworzeniu
        board.placeToken(this.col, this.row, this);
    }

    // Wymagane przez PlayerTest.new_PlayerToken_is_placed_on_the_board
    public Board.Coords pos() {
        return new Board.Coords(col, row);
    }

    // Wymagane przez wszystkie testy ruchu (PlayerTest)
    public void move(Move direction) {
        int newCol = this.col;
        int newRow = this.row;

        switch (direction) {
            case UP:
                newRow--;
                break;
            case DOWN:
                newRow++;
                break;
            case LEFT:
                newCol--;
                break;
            case RIGHT:
                newCol++;
                break;
            case NONE:
                return; // Nie ruszamy się
        }

        // Sprawdzanie granic planszy i rzucanie wyjątku (PlayerTest.stay_inside_...)
        if (newCol < 0 || newCol >= board.size() || newRow < 0 || newRow >= board.size()) {
            throw new IllegalArgumentException("Ruch poza granice planszy!");
        }

        // Aktualizacja planszy i pozycji
        board.placeToken(this.col, this.row, new EmptyToken()); // Poprzednie pole jest puste
        this.col = newCol;
        this.row = newRow;
        board.placeToken(this.col, this.row, this); // Nowe pole zajęte
    }
}