package sn.uasz.m1.tp1.collection.test;

import java.util.ArrayList;
import java.util.List;
import sn.uasz.m1.tp1.collection.Annuaire;
import sn.uasz.m1.tp1.collection.Civilite;
import sn.uasz.m1.tp1.collection.Employe;
import sn.uasz.m1.tp1.collection.UnAnnuaire;

/**
 * Programme principal de test de l'Annuaire.
 *
 * Exécution :
 *   javac sn/uasz/m1/tp1/collection/test/TestAnnuaire.java
 *   java  sn.uasz.m1.tp1.collection.test.TestAnnuaire
 */
public class TestAnnuaire {

    public static void main(String[] args) {

        // Création d'un annuaire vide
        Annuaire an = new UnAnnuaire();

        // Création de listes de numéros de téléphone
        List<Long> lst1 = new ArrayList<>(); lst1.add(7701L);
        List<Long> lst2 = new ArrayList<>(); lst2.add(7702L); lst2.add(3301L);
        List<Long> lst3 = new ArrayList<>(); lst3.add(7703L);
        List<Long> lst4 = new ArrayList<>(); lst4.add(7704L);

        // Ajout de quatre employés à l'annuaire
        Employe e1 = new Employe(Civilite.MLLE, "DIOUF", "Nafissatou", "Caissière");
        an.ajouter(e1, lst1);
        an.ajouter(new Employe(Civilite.MR,  "FALL",   "Aliou",  "Chauffeur"), lst2);
        an.ajouter(new Employe(Civilite.MME, "DIATTA", "Jeanne", "Receveur"),  lst3);
        an.ajouter(new Employe(Civilite.MR,  "NDIAYE", "Lamine", "Chauffeur"), lst4);

        // Impression de l'annuaire (trié par nom grâce à TreeMap + Comparable)
        System.out.println("------------------------------");
        System.out.println(an);
        System.out.println("------------------------------");

        // Recherche des numéros de Mlle Nafissatou DIOUF
        System.out.println("Numeros de " + e1);
        System.out.println(an.getNumeros(e1));

        // Recherche des numéros de M. Aliou FALL avec un NOUVEL objet
        // Fonctionne grâce à equals/hashCode redéfinis
        Employe e2 = new Employe(Civilite.MR, "FALL", "Aliou", "Chauffeur");
        System.out.println("Numeros de " + e2);
        System.out.println(an.getNumeros(e2));
    }
}
