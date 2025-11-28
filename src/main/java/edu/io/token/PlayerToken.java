package edu.io.token;

import edu.io.Board;
import edu.io.Player;

public class PlayerToken extends Token {
    private final Board board;
    private final Player player;
    private int col;
    private int row;


    public enum Move {
        NONE, UP, DOWN, LEFT, RIGHT
    }


    @Override
    public String label() {
        return Label.PLAYER_TOKEN_LABEL;
    }

    // Wymagane przez PlayerTest.new_PlayerToken_is_placed_on_the_board
    public PlayerToken(Player player, Board board) {
        super(Label.PLAYER_TOKEN_LABEL);
        this.board = board;
        this.player = player;// Ustawienie początkowej pozycji na (0, 0)
        this.col = 0; 
        this.row = 0;

        board.placeToken(this.col, this.row, this);
    }


    public Board.Coords pos() {
        return new Board.Coords(row, col);
    }


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
                return;
        }


        if (newCol < 0 || newCol >= board.size() || newRow < 0 || newRow >= board.size()) {
            throw new IllegalArgumentException("Ruch poza granice planszy!");
        }

        // Aktualizacja planszy i pozycji
        board.placeToken(this.col, this.row, new EmptyToken());
        this.col = newCol;
        this.row = newRow;
        board.placeToken(this.col, this.row, this);
    }
}