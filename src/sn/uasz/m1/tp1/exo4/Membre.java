package sn.uasz.m1.tp1.exo4;

/**
 * TP1 - Exercice 4 : un membre du club informatique de l'UASZ.
 * L'égalité de deux membres est définie par l'égalité de leurs identifiants.
 */
public class Membre {

    private String identifiant;
    private String nom;
    private String profession;
    private Sexe sexe;
    private String telephone;

    /** Constructeur par défaut (utile pour certains frameworks). */
    public Membre() {}

    /** Constructeur d'initialisation. */
    public Membre(String identifiant, String nom, String profession, Sexe sexe, String telephone) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.profession = profession;
        this.sexe = sexe;
        this.telephone = telephone;
    }

    // Getters
    public String getIdentifiant() { return identifiant; }
    public String getNom() { return nom; }
    public String getProfession() { return profession; }
    public Sexe getSexe() { return sexe; }
    public String getTelephone() { return telephone; }

    // Setters
    public void setIdentifiant(String identifiant) { this.identifiant = identifiant; }
    public void setNom(String nom) { this.nom = nom; }
    public void setProfession(String profession) { this.profession = profession; }
    public void setSexe(Sexe sexe) { this.sexe = sexe; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    @Override
    public String toString() {
        return String.format("Membre [id = %s, nom = %s, profession = %s, sexe = %s, tel = %s]",
                identifiant, nom, profession, sexe, telephone);
    }

    /** Deux membres sont égaux ssi ils ont le même identifiant. */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Membre other)) return false;
//        Membre other = (Membre) o; // casting
        return this.identifiant.equals(other.identifiant);
    }

    @Override
    public int hashCode() {
        return this.identifiant.hashCode();
    }
}
