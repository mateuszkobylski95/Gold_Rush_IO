package edu.io.token;

public class EmptyToken extends Token {
    public EmptyToken() {
        super(Label.EMPTY_TOKEN_LABEL);
    }
    
    @Override
    public String label() {
        return Label.EMPTY_TOKEN_LABEL;
    }
}