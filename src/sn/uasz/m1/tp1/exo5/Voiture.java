package sn.uasz.m1.tp1.exo5;

import java.util.Objects;

/**
 * TP1 - Exercice 5 : représentation d'une voiture.
 * L'égalité est définie par l'immatriculation ET la marque.
 */
public class Voiture {

    private String immatriculation;
    private String marque;
    private int kilometrage;
    private Carburant carburant;
    private String couleur;

    public Voiture(String immatriculation, String marque, int kilometrage,
                   Carburant carburant, String couleur) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.kilometrage = kilometrage;
        this.carburant = carburant;
        this.couleur = couleur;
    }

    // Getters
    public String getImmatriculation() { return immatriculation; }
    public String getMarque() { return marque; }
    public int getKilometrage() { return kilometrage; }
    public Carburant getCarburant() { return carburant; }
    public String getCouleur() { return couleur; }

    // Setters
    public void setKilometrage(int kilometrage) { this.kilometrage = kilometrage; }
    public void setCouleur(String couleur) { this.couleur = couleur; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Voiture)) return false;
        Voiture v = (Voiture) o;
        return Objects.equals(immatriculation, v.immatriculation)
            && Objects.equals(marque, v.marque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(immatriculation, marque);
    }

    @Override
    public String toString() {
        return String.format("[%s | %s | %d km | %s | %s]",
                immatriculation, marque, kilometrage, carburant, couleur);
    }
}
