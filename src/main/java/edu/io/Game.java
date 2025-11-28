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

            System.out.print(
                    "Wybierz kierunek ruchu (lewo (l)  góra, dół (d) - dół, lewo (l) - lewo, prawo (p) - prawo, koniec (k) zakończ grę)  "
            );
            String playerInput = inputScanner.nextLine().trim().toLowerCase();
            PlayerToken.Move move = switch (playerInput) {
                case "góra", "g" -> PlayerToken.Move.UP;
                case "dół", "d" -> PlayerToken.Move.DOWN;
                case "lewo", "l" -> PlayerToken.Move.LEFT;
                case "prawo", "p" -> PlayerToken.Move.RIGHT;
                default -> PlayerToken.Move.NONE;
            };

            if (playerInput.equals("k") || playerInput.equals("koniec")) {
                shouldRun = false;
                break;
            }


            if (move == PlayerToken.Move.NONE) {
                System.out.println("Niepoprawny kierunek. Spróbuj ponownie.");
                continue;
            }

            try {
                player.token().move(move);
                board.display();


            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

            }
        }


    }
}