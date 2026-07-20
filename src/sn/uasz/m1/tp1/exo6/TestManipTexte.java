package sn.uasz.m1.tp1.exo6;

/**
 * Programme de test pour ManipTexte.
 * Exécution :
 *   javac sn/uasz/m1/tp1/exo6/TestManipTexte.java
 *   java  sn.uasz.m1.tp1.exo6.TestManipTexte
 */
public class TestManipTexte {

    public static void main(String[] args) {
        String texte = "Bonjour tout le monde. Bienvenue au cours de programmation Java. "
                     + "Java est un langage de programmation. "
                     + "Programmation, programmation, programmation !";

        ManipTexte mt = new ManipTexte(texte);

        System.out.println("--- Mots et fréquences (ordre quelconque) ---");
        mt.afficherMots();

        System.out.println("\n--- Trié par fréquence décroissante ---");
        mt.afficherMotsEnOrdre();

        Object[] top = mt.plusFrequent();
        if (top != null) {
            System.out.println("\nMot le plus fréquent : \"" + top[0] + "\" (" + top[1] + " occurrences)");
        }
    }
}
