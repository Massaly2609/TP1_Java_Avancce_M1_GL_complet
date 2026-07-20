package sn.uasz.m1.tp1.exo5;

/** Levée quand on tente d'accéder à une place hors capacité. */
public class PlaceInexistanteException extends Exception {
    public PlaceInexistanteException(int place, int capacite) {
        super("Place " + place + " inexistante (capacité = " + capacite + ").");
    }
}
