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

    public PlayerToken(Player player, Board board) {
        super(Label.PLAYER_TOKEN_LABEL);
        this.board = board;
        this.player = player;
        this.col = 0;
        this.row = 0;

        board.placeToken(this.col, this.row, this);
    }


    public Board.Coords pos() {
        return new Board.Coords(row, col);
    }


    public void move(Move direction) {
        int colAfterMove = this.col;
        int rowAfterMove = this.row;

        switch (direction) {
            case UP:
                rowAfterMove--;
                break;
            case DOWN:
                rowAfterMove++;
                break;
            case LEFT:
                colAfterMove--;
                break;
            case RIGHT:
                colAfterMove++;
                break;
            case NONE:
                return;
        }

        if (colAfterMove < 0 || colAfterMove >= board.size() || rowAfterMove < 0 || rowAfterMove >= board.size()) {
            throw new IllegalArgumentException("Niedozwolony ruch");
        }
        player.interactWithToken(board.peekToken(this.col, this.row));
        board.placeToken(this.col, this.row, new EmptyToken());
        this.col = colAfterMove;
        this.row = rowAfterMove;
        board.placeToken(this.col, this.row, this);
    }
}