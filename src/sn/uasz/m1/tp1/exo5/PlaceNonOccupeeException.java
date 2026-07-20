package sn.uasz.m1.tp1.exo5;

/** Levée quand on tente de retirer une voiture d'une place libre. */
public class PlaceNonOccupeeException extends Exception {
    public PlaceNonOccupeeException(int place) {
        super("La place " + place + " est libre.");
    }
}
