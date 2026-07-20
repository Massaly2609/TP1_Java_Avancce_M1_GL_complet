package sn.uasz.m1.tp1.exo7;

/** Levée lors d'un dépilement sur une pile vide. */
public class EmptyPileException extends Exception {
    public EmptyPileException() {
        super("Impossible de dépiler : la pile est vide.");
    }

    public EmptyPileException(String message) {
        super(message);
    }
}
