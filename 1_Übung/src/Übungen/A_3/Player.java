package Übungen.A_3;

public class Player {
    private final String Name;
    private final Character Symbol;

    public Player(String name, Character symbol) {
        Name = name;
        Symbol = symbol;
    }


    public String getName() {
        return Name;
    }

    public Character getSymbol() {
        return Symbol;
    }
}
