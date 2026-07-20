package sn.uasz.m1.tp1.exo4;

/** Levée si l'on tente d'ajouter un membre avec un identifiant déjà utilisé. */
public class IdentifiantExistantException extends Exception {
    public IdentifiantExistantException(String id) {
        super("L'identifiant '" + id + "' est déjà utilisé.");
    }
}
