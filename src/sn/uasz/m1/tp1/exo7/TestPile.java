package sn.uasz.m1.tp1.exo7;

/**
 * Test de la PileList : empile trois chaînes, puis dépile jusqu'au bout
 * pour montrer la levée d'EmptyPileException.
 */
public class TestPile {

    public static void main(String[] args) {
        PileList pile = new PileList();

        pile.empiler("Pascal");
        pile.empiler("Java");
        pile.empiler("Python");

        System.out.println("Avant dépilement : " + pile);
        // [Pascal, Java, Python]

        try {
            // L'ordre de dépilement est inverse de celui d'empilement (LIFO)
            System.out.println("Dépilé : " + pile.depiler()); // Python
            System.out.println("Dépilé : " + pile.depiler()); // Java
            System.out.println("Dépilé : " + pile.depiler()); // Pascal
            System.out.println("Dépilé : " + pile.depiler()); // 💥 EmptyPileException
        } catch (EmptyPileException e) {
            System.out.println("⚠ " + e.getMessage());
        }

        System.out.println("Après dépilement : " + pile);
    }
}
