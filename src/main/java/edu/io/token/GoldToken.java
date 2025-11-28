package edu.io.token;

public class GoldToken extends Token {

    private final double amount;
    
    public GoldToken() {
        this(1.0);
    }

    public GoldToken(double amount) throws IllegalArgumentException {
        super(Label.GOLD_TOKEN_LABEL);
        if (amount < 0) throw new IllegalArgumentException("Ilość złota nie może być ujemna");
        this.amount = amount;
    }

    @Override
    public String label() {
        return Label.GOLD_TOKEN_LABEL;
    }
    public double amount() {
        return amount;
    }
}