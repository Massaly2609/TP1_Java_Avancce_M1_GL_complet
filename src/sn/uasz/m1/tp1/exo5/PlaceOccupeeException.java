package sn.uasz.m1.tp1.exo5;

/** Levée quand on tente de garer sur une place déjà occupée. */
public class PlaceOccupeeException extends Exception {
    public PlaceOccupeeException(int place) {
        super("La place " + place + " est déjà occupée.");
    }
}
