package sn.uasz.m1.tp1.collection;

/** Civilité d'un employé. */
public enum Civilite {
    MR("M."),
    MLLE("Mlle"),
    MME("Mme"),
    INCONNU("?");

    private final String libelle;

    Civilite(String libelle) { this.libelle = libelle; }

    public String getLibelle() { return libelle; }

    @Override
    public String toString() { return libelle; }
}
