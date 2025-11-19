package edu.io.token;

import java.lang.reflect.Modifier;

public abstract class Token {
    // Wymagane przez TokenTest.token_has_only_one_ctor (chociaż test dopuszcza publiczny ctor)
    public Token() {
        // Pusty konstruktor wymagany, aby mieć tylko jeden
    }
    
    public abstract String label();
}