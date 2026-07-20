package sn.uasz.m1.tp1.exo4;

/** Levée si l'on cherche/modifie/supprime un membre dont l'identifiant n'existe pas. */
public class InexistantMembreException extends Exception {
    public InexistantMembreException(String id) {
        super("Aucun membre avec l'identifiant '" + id + "'.");
    }
}
