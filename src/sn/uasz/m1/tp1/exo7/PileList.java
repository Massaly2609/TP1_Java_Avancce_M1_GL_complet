package sn.uasz.m1.tp1.exo7;

import java.util.ArrayList;

/**
 * Implémentation d'une pile (LIFO) en utilisant une ArrayList comme
 * structure interne. Le sommet de la pile est le dernier élément de la liste.
 */
public class PileList implements Pile {

    private ArrayList<Object> elements = new ArrayList<>();

    @Override
    public boolean estVide() {
        return elements.isEmpty();
    }

    @Override
    public void empiler(Object obj) {
        elements.add(obj); // ajout en fin = sommet
    }

    @Override
    public Object depiler() throws EmptyPileException {
        if (estVide()) {
            throw new EmptyPileException();
        }
        return elements.remove(elements.size() - 1);
    }

    public int taille() { return elements.size(); }

    @Override
    public String toString() {
        return "Pile" + elements;
    }
}
