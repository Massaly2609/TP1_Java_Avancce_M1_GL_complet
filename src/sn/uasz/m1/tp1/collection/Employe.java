package sn.uasz.m1.tp1.collection;

import java.util.Objects;

/**
 * TP2 - Exercice 8 : représentation d'un employé.
 *
 * Version FINALE qui :
 *  - redéfinit equals() et hashCode() (cohérents) pour fonctionner comme clé de HashMap
 *  - implémente Comparable<Employe> pour fonctionner comme clé de TreeMap
 *
 * Le contrat de cohérence est respecté :
 *   a.equals(b)  ⇔  a.compareTo(b) == 0
 */
public class Employe implements Comparable<Employe> {

    private Civilite civilite;
    private String nom;
    private String prenom;
    private String fonction;

    /** Constructeur principal. */
    public Employe(Civilite civilite, String nom, String prenom, String fonction) {
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.fonction = fonction;
    }

    /** Constructeur sans civilité (initialisée à INCONNU). */
    public Employe(String nom, String prenom, String fonction) {

        this(Civilite.INCONNU, nom, prenom, fonction);
    }

    // Getters
    public Civilite getCivilite() { return civilite; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getFonction() { return fonction; }

    // Setter pour la civilité (modifiable)
    public void setCivilite(Civilite civilite) { this.civilite = civilite; }

    @Override
    public String toString() {
        return civilite + " " + prenom + " " + nom + " (" + fonction + ")";
    }

    // =================== HashMap : equals / hashCode ===================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employe)) return false;
        Employe other = (Employe) o;
        return Objects.equals(nom, other.nom)
            && Objects.equals(prenom, other.prenom)
            && Objects.equals(fonction, other.fonction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, fonction);
    }

    // =================== TreeMap : compareTo ===================

    @Override
    public int compareTo(Employe other) {
        int cmp = nom.compareTo(other.nom);
        if (cmp != 0) return cmp;
        cmp = prenom.compareTo(other.prenom);
        if (cmp != 0) return cmp;
        return fonction.compareTo(other.fonction);
    }
}
