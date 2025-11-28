package edu.io;

import edu.io.token.PlayerToken;

import java.util.Scanner;


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

    public void start() {
        boolean shouldRun = true;

        Scanner inputScanner = new Scanner(System.in);
        board.display();
        while (shouldRun) {

            boolean validMove = true;
            do {
                System.out.print("Wpisz by wykonać ruch (w -  ruch w górę, s - ruch w dół, a - ruch w lewo, d - ruch w prawo, k by zakończyć grę)>> ");
                String input = inputScanner.nextLine().toLowerCase();
                if (input.equals("k")) {
                    shouldRun = false;
                    break;
                }
                PlayerToken.Move move = switch (input) {
                    case "w" -> PlayerToken.Move.UP;
                    case "s" -> PlayerToken.Move.DOWN;
                    case "a" -> PlayerToken.Move.LEFT;
                    case "d" -> PlayerToken.Move.RIGHT;
                    default -> PlayerToken.Move.NONE;
                };

                if (move.equals(PlayerToken.Move.NONE)) {
                    System.out.println("Niepoprawny kierunek. Spróbuj ponownie");
                } else {
                    try {
                        player.token().move(move);
                        board.display();

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        validMove = false;
                    }
                }
            } while (!validMove);
        }


    }
}