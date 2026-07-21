package sn.uasz.m1.tp1.exo4;

import java.util.HashMap;
import java.util.Map;

/**
 * Club informatique de l'UASZ.
 * Les membres sont stockés dans une Map indexée par l'identifiant.
 */
public class Club {

    private Map<String, Membre> membres = new HashMap<>();

    /**
     * Ajoute un nouveau membre.
     * @throws IdentifiantExistantException si l'identifiant est déjà utilisé.
     */
    public void ajouter(Membre m) throws IdentifiantExistantException {
        if (membres.containsKey(m.getIdentifiant())) {
            throw new IdentifiantExistantException(m.getIdentifiant());
        }
        membres.put(m.getIdentifiant(), m);
    }

    /**
     * Modifie un membre existant à partir des informations fournies.
     * On accepte un objet Membre déjà rempli pour simplifier les tests
     * (l'identifiant détermine quel membre modifier).
     * @throws InexistantMembreException si l'identifiant est inconnu.
     */
    public void modifier(String identifiant, Membre nouveau) throws InexistantMembreException {
        if (!membres.containsKey(identifiant)) {
            throw new InexistantMembreException(identifiant);
        }
        Membre actuel = membres.get(identifiant);
        if (nouveau.getNom() != null)        actuel.setNom(nouveau.getNom());
        if (nouveau.getProfession() != null) actuel.setProfession(nouveau.getProfession());
        if (nouveau.getSexe() != null)       actuel.setSexe(nouveau.getSexe());
        if (nouveau.getTelephone() != null)  actuel.setTelephone(nouveau.getTelephone());
    }

    /**
     * Supprime un membre.
     * @throws InexistantMembreException si l'identifiant est inconnu.
     */
    public void supprimer(String identifiant) throws InexistantMembreException {
        if (!membres.containsKey(identifiant)) {
            throw new InexistantMembreException(identifiant);
        }
        membres.remove(identifiant); // Suppression du membre
    }

    /** Affiche l'ensemble des membres du club. */
    public void afficher() {
        if (membres.isEmpty()) {
            System.out.println("(aucun membre)");
            return;
        }
//        for (Membre m : membres.values()) {
//            System.out.println(m);
//        }

        for(Map.Entry<String, Membre> e : membres.entrySet()){
            System.out.println(e.getKey() + " => " + e.getValue());
        }
    }

    public int taille() { return membres.size(); }
    public Map<String, Membre> getMembres() { return membres; }
}
