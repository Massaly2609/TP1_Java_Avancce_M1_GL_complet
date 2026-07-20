package sn.uasz.m1.tp1.exo5;

/**
 * Programme principal de test du Parking.
 * Exécution :
 *   javac sn/uasz/m1/tp1/exo5/GestionParking.java
 *   java  sn.uasz.m1.tp1.exo5.GestionParking
 */
public class GestionParking {

    public static void main(String[] args) {
        Parking p = new Parking(5);

        Voiture v1 = new Voiture("AA-001-BB", "Toyota",  50_000, Carburant.ESSENCE,    "Rouge");
        Voiture v2 = new Voiture("CC-002-DD", "Renault", 12_500, Carburant.DIESEL,     "Noir");
        Voiture v3 = new Voiture("EE-003-FF", "Tesla",    3_000, Carburant.ELECTRIQUE, "Blanc");

        // --- Garer ---
        try {
            p.garer(v1, 1);
            p.garer(v2, 3);
            p.garer(v3, 1); // 💥 place occupée
        } catch (PlaceInexistanteException | PlaceOccupeeException e) {
            System.out.println("⚠ (attendu) " + e.getMessage());
        }

        try {
            p.garer(v3, 99); // 💥 place inexistante
        } catch (PlaceInexistanteException | PlaceOccupeeException e) {
            System.out.println("⚠ (attendu) " + e.getMessage());
        }

        // OK : place 5 libre
        try {
            p.garer(v3, 5);
        } catch (Exception e) {
            System.out.println("⚠ inattendu : " + e.getMessage());
        }

        p.afficher();

        // --- Recherche par immatriculation ---
        System.out.println("\nTesla à la place : "    + p.placeOccupee("EE-003-FF"));
        System.out.println("XX-000-YY à la place : " + p.placeOccupee("XX-000-YY"));

        // --- Retirer ---
        try {
            p.retirer(3);  // OK
            p.retirer(3);  // 💥 maintenant libre
        } catch (PlaceInexistanteException | PlaceNonOccupeeException e) {
            System.out.println("⚠ (attendu) " + e.getMessage());
        }

        p.afficher();
    }
}
