package sn.uasz.m1.tp1.exo3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestion des employés d'une société.
 * Permet d'enregistrer, filtrer par date d'embauche et par salaire,
 * et de trouver l'employé le mieux payé.

 * Exécution :
 *   javac sn/uasz/m1/tp1/exo3/GestionEmploye.java
 *   java  sn.uasz.m1.tp1.exo3.GestionEmploye
 */
public class GestionEmploye {

    private List<Employe> employes = new ArrayList<>();

    /** Enregistre un employé. */
    public void enregistrer(Employe e) {
      // add(E e) -> ajouter
        employes.add(e);
    }

    /** Liste des employés embauchés EXACTEMENT à la date donnée. */
    public List<Employe> embauchesA(LocalDate date) {
        List<Employe> resultat = new ArrayList<>();
        for (Employe e : employes) {
            if (e.getDateEmbauche().equals(date)) {
                resultat.add(e);
            }
        }
        return resultat;
    }

    /** Liste des employés embauchés strictement AVANT la date donnée. */
    public List<Employe> embauchesAvant(LocalDate date) {
        List<Employe> resultat = new ArrayList<>();
        for (Employe e : employes) {
            if (e.getDateEmbauche().isBefore(date)) {
                resultat.add(e);
            }
        }
        return resultat;
    }

    /** Employés embauchés avant date et gagnant plus de salaireMin. */
    public List<Employe> embauchesAvantEtSalairePlus(LocalDate date, double salaireMin) {
        List<Employe> resultat = new ArrayList<>();
        for (Employe e : employes) {
            if (e.getDateEmbauche().isBefore(date) && e.getSalaire() > salaireMin) {
                resultat.add(e);
            }
        }
        return resultat;
    }

    /** Renvoie l'employé le mieux payé, ou null si la liste est vide. */
    public Employe mieuxPaye() {
        if (employes.isEmpty()) return null;
        Employe meilleur = employes.get(0);    // Suppose que le premier est le mieux payé
         for (Employe e : employes) {
            if (e.getSalaire() > meilleur.getSalaire()) {
                meilleur = e;
            }
        }
        return meilleur;
    }

    // ============== Programme principal (jeu d'essai) ==============
    public static void main(String[] args) {
        GestionEmploye g = new GestionEmploye();

        g.enregistrer(new Employe("M001", "DIOUF",   450_000, LocalDate.of(2020, 1, 15)));
        g.enregistrer(new Employe("M002", "FALL",    320_000, LocalDate.of(2022, 6, 1)));
        g.enregistrer(new Employe("M003", "NDIAYE",  280_000, LocalDate.of(2020, 1, 15)));
        g.enregistrer(new Employe("M004", "DIATTA",  600_000, LocalDate.of(2019, 9, 12)));
        g.enregistrer(new Employe("M005", "SARR",    410_000, LocalDate.of(2023, 3, 20)));

        System.out.println("--- Embauchés le 15/01/2020 ---");
        for (Employe e : g.embauchesA(LocalDate.of(2020, 1, 15))) {
            System.out.println(e);
        }

        System.out.println("\n--- Embauchés avant le 01/01/2021 ---");
        for (Employe e : g.embauchesAvant(LocalDate.of(2021, 1, 1))) {
            System.out.println(e);
        }

        System.out.println("\n--- Avant 01/01/2023 ET salaire > 300 000 ---");
        for (Employe e : g.embauchesAvantEtSalairePlus(LocalDate.of(2023, 1, 1), 300_000)) {
            System.out.println(e);
        }

        System.out.println("\n--- Mieux payé ---");
        System.out.println(g.mieuxPaye());
    }
}
