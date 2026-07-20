package sn.uasz.m1.tp1.collection;

import java.util.List;

/**
 * Interface décrivant un annuaire associant à un employé une liste de numéros
 * de téléphone.
 */
public interface Annuaire {

    /** Ajoute une nouvelle entrée. Renvoie false si l'employé est déjà présent. */
    boolean ajouter(Employe e, List<Long> numeros);

    /** Ajoute un numéro à la liste des numéros d'un employé. */
    void ajouterNumero(Employe e, long numero);

    /** Retire un numéro de la liste des numéros d'un employé. */
    void retirerNumero(Employe e, long numero);

    /** Supprime un employé de l'annuaire. */
    void supprimer(Employe e);

    /** Renvoie la liste des numéros d'un employé (ou null si inconnu). */
    List<Long> getNumeros(Employe e);

    @Override
    String toString();
}
