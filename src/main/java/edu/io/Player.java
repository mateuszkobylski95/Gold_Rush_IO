package edu.io;

import edu.io.token.*;

public class Player {
    private double gold;
    private PlayerToken token;

    public void assignToken(PlayerToken token) {
        this.token = token;
    }

    public PlayerToken token() {
        return token;
    }

    public double gold() {
        return this.gold;
    }

    public void gainGold(double amount) throws IllegalArgumentException {
        if (amount < 0) throw new IllegalArgumentException("Zysk złota musi być liczbą dodatnią");
        this.gold += amount;
    }

    public void loseGold(double amount) throws IllegalArgumentException {
        if (amount < 0) throw new IllegalArgumentException("Wartość utraty złota musi być liczbą dodatnią");
        double updatedGoldAmount = this.gold - amount;
        if (updatedGoldAmount < 0) throw new IllegalArgumentException("Suma złota nie może być ujemna");
        this.gold = updatedGoldAmount;
    }

    public void interactWithToken(Token token) {

        if (token instanceof GoldToken goldToken) {
            gainGold(goldToken.amount());
        }
    }
}