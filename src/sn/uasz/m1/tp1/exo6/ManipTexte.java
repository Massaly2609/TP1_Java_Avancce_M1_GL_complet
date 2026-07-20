package sn.uasz.m1.tp1.exo6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * TP1 - Exercice 6 : manipulation d'un texte.
 * Compte les mots, trouve le plus fréquent, trie par fréquence.
 */
public class ManipTexte {

    private String texte;

    /** Caractères utilisés comme séparateurs entre mots. */
    private static final String SEPARATEURS = " \t\n\r.,;:!?()\"'";

    public ManipTexte(String texte) {
        this.texte = texte;
    }

    public String getTexte() { return texte; }
    public void setTexte(String texte) { this.texte = texte; }

    /**
     * Calcule la fréquence de chaque mot (insensible à la casse).
     */
    public HashMap<String, Integer> compte() {
        HashMap<String, Integer> freq = new HashMap<>();
        StringTokenizer tok = new StringTokenizer(texte, SEPARATEURS);
        while (tok.hasMoreTokens()) {
            String mot = tok.nextToken().toLowerCase();
            freq.put(mot, freq.getOrDefault(mot, 0) + 1);
        }
        return freq;
    }

    /** Affiche les couples (mot, fréquence). */
    public void afficherMots() {
        HashMap<String, Integer> freq = compte();
        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }

    /**
     * @return un tableau [mot le plus fréquent, occurrences] ou null si vide.
     */
    public Object[] plusFrequent() {
        HashMap<String, Integer> freq = compte();
        if (freq.isEmpty()) return null;

        String motMax = null;
        int max = 0;
        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                motMax = e.getKey();
            }
        }
        return new Object[] { motMax, max };
    }

    /** Affiche les mots dans l'ordre décroissant de leurs fréquences. */
    public void afficherMotsEnOrdre() {
        HashMap<String, Integer> freq = compte();
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freq.entrySet());
        entries.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        for (Map.Entry<String, Integer> e : entries) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }
}
