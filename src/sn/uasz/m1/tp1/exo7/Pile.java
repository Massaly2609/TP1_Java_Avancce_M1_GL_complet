package sn.uasz.m1.tp1.exo7;

/**
 * Interface décrivant une pile (LIFO - Last In, First Out).
 */
public interface Pile {
    boolean estVide();
    void empiler(Object obj);
    Object depiler() throws EmptyPileException;
}
