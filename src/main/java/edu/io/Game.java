package edu.io;

import edu.io.token.PlayerToken;


public class Game {
    private Player player;
    private final Board board;

    public Game() {
        board = new Board();
    }
    
    public void join(Player player) {
        this.player = player;
        this.player.assignToken(new PlayerToken(this.player, this.board));
    }

    public void start() {}
}