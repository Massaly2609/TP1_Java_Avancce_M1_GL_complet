package sn.uasz.m1.tp1.exo3;

import java.time.LocalDate;

/**
 * TP1 - Exercice 3 : représentation d'un employé.
 */
public class Employe {

    private String matricule;
    private String nom;
    private double salaire;
    private LocalDate dateEmbauche;

    public Employe(String matricule, String nom, double salaire, LocalDate dateEmbauche) {
        this.matricule = matricule;
        this.nom = nom;
        this.salaire = salaire;
        this.dateEmbauche = dateEmbauche;
    }

    // Getters
    public String getMatricule() { return matricule; }
    public String getNom() { return nom; }
    public double getSalaire() { return salaire; }
    public LocalDate getDateEmbauche() { return dateEmbauche; }

    // Setters
    public void setNom(String nom) { this.nom = nom; }
    public void setSalaire(double salaire) { this.salaire = salaire; }
    public void setDateEmbauche(LocalDate dateEmbauche) { this.dateEmbauche = dateEmbauche; }

    @Override
    public String toString() {
        return String.format("Employe => [ matricule=%s, nom=%s, salaire=%.2f, embauche=%s ]",
                matricule, nom, salaire, dateEmbauche);
    }
}
