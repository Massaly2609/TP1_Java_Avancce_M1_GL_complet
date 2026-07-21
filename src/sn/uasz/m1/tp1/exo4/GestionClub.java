package sn.uasz.m1.tp1.exo4;

/**
 * Programme principal de test du Club.
 * Exécution :
 *   javac sn/uasz/m1/tp1/exo4/GestionClub.java
 *   java  sn.uasz.m1.tp1.exo4.GestionClub
 */
public class GestionClub {

    public static void main(String[] args) {
        Club club = new Club();

        // --- 1) Ajout de trois membres  au club ---
        try {

            club.ajouter(new Membre("ID01", "DIOUF",  "Étudiant",   Sexe.HOMME, "77 100 00 00"));
            club.ajouter(new Membre("ID02", "DIATTA", "Enseignante", Sexe.FEMME, "77 200 00 00"));
            club.ajouter(new Membre("ID03", "FALL",   "Étudiant",   Sexe.HOMME, "77 300 00 00"));
            System.out.println("✓ 3 membres ajoutés (" + club.taille() + " au total)");

        } catch (IdentifiantExistantException e) {
            System.out.println("⚠ " + e.getMessage());
        }

        // --- 2) Tentative d'ajouter un doublon ---
        try {
            club.ajouter(new Membre("ID02", "AUTRE", "X", Sexe.FEMME, "00"));
        } catch (IdentifiantExistantException e) {
            System.out.println("⚠ (attendu) " + e.getMessage());
        }

        // --- 3) Modification d'un membre existant ---
        try {
            Membre maj = new Membre();
            maj.setProfession("Doctorante");
            maj.setTelephone("77 999 99 99");
            club.modifier("ID02", maj);
            System.out.println("✓ ID02 modifié.");
        } catch (InexistantMembreException e) {
            System.out.println("⚠ " + e.getMessage());
        }

        // --- 4) Suppression ---
        try {
            club.supprimer("ID03");
            System.out.println("✓ ID03 supprimé.");
            club.supprimer("ZZ99"); // inexistant
        } catch (InexistantMembreException e) {
            System.out.println("⚠ (attendu) " + e.getMessage());
        }

        // --- 5) Affichage final ---
        System.out.println("\n=== État final du club ===");
        club.afficher();
    }
}
