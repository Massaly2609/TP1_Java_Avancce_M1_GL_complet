package sn.uasz.m1.tp1.exo5;

import java.util.HashMap;
import java.util.Map;

/**
 * TP1 - Exercice 5 : parking automobile.
 * Les voitures sont stockées dans une Map (numéro de place → voiture).
 */
public class Parking {

    private int capacite;
    private Map<Integer, Voiture> voitures = new HashMap<>();

    public Parking(int capacite) {
        if (capacite <= 0) {
            throw new IllegalArgumentException("La capacité doit être strictement positive");
        }
        this.capacite = capacite;
    }

    public int getCapacite() { return capacite; }
    public Map<Integer, Voiture> getVoitures() { return voitures; }

    /** Vérifie que le numéro de place est compris entre 1 et la capacité. */
    private void verifierNumero(int place) throws PlaceInexistanteException {
        if (place < 1 || place > capacite) { // place compris entre ]1, capacite[
            throw new PlaceInexistanteException(place, capacite);
        }
    }

    /**
     * Gare la voiture à la place donnée si celle-ci est libre.
     * @throws PlaceInexistanteException si le numéro de place est invalide.
     * @throws PlaceOccupeeException si la place est déjà prise.
     */
    public void garer(Voiture v, int place)
            throws PlaceInexistanteException, PlaceOccupeeException {
        verifierNumero(place);
        if (voitures.containsKey(place)) {
            throw new PlaceOccupeeException(place);
        }
        voitures.put(place, v);
    }

    /**
     * Retire la voiture de la place donnée.
     * @throws PlaceInexistanteException si le numéro de place est invalide.
     * @throws PlaceNonOccupeeException si la place est libre.
     */
    public void retirer(int place)
            throws PlaceInexistanteException, PlaceNonOccupeeException {
        verifierNumero(place);
        if (!voitures.containsKey(place)) {
            throw new PlaceNonOccupeeException(place);
        }
        voitures.remove(place);
    }

    /** Affiche l'état du parking, place par place. */
    public void afficher() {
        System.out.println("=== État du parking (capacité " + capacite + ") ===");
        for (int p = 1; p <= capacite; p++) {
            Voiture v = voitures.get(p);
            System.out.println("Place " + p + " : " + (v == null ? "(libre)" : v));
        }

        System.out.println("-------------------Parking (Place occupée)---------------------");
        for(Map.Entry<Integer, Voiture> v : voitures.entrySet()){
            System.out.println("Place " + v.getKey() + " : " + v.getValue());
        }

    }

    /**
     * Renvoie le numéro de place de la voiture portant cette immatriculation,
     * ou -1 si elle n'est pas garée dans ce parking.
     */
    public int placeOccupee(String immatriculation) {
        for (Map.Entry<Integer, Voiture> entry : voitures.entrySet()) {
            if (entry.getValue().getImmatriculation().equals(immatriculation)) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
