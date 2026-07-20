package sn.uasz.m1.tp1.exo2;

/**
 * Exception métier levée pour signaler une opération arithmétique invalide :
 *  - division par zéro,
 *  - racine carrée d'une somme négative,
 *  - test de divisibilité avec valeur(s) négative(s) ou nulle(s).
 */
public class OperationException extends Exception {

    public OperationException() {
        super();
    }

    public OperationException(String message) {
        super(message);
    }
}
