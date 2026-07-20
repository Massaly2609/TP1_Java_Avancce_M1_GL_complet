package sn.uasz.m1.tp1.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Implémentation de l'Annuaire à l'aide d'une TreeMap, ce qui garantit
 * que les employés apparaissent dans l'ordre naturel (cf. Employe.compareTo).
 *
 * Pour la version HashMap, il suffit de remplacer "new TreeMap<>()" par
 * "new HashMap<>()".
 */
public class UnAnnuaire implements Annuaire {

    private Map<Employe, List<Long>> entrees = new TreeMap<>();

    @Override
    public boolean ajouter(Employe e, List<Long> numeros) {
        if (entrees.containsKey(e)) {
            return false; // déjà présent
        }
        // On copie la liste pour ne pas la partager avec l'extérieur
        entrees.put(e, new ArrayList<>(numeros));
        return true;
    }

    @Override
    public void ajouterNumero(Employe e, long numero) {
        List<Long> lst = entrees.get(e);
        if (lst != null) {
            lst.add(numero);
        }
    }

    @Override
    public void retirerNumero(Employe e, long numero) {
        List<Long> lst = entrees.get(e);
        if (lst != null) {
            // numero est un long → autoboxing en Long → remove(Object)
            lst.remove(Long.valueOf(numero));
        }
    }

    @Override
    public void supprimer(Employe e) {
        entrees.remove(e);
    }

    @Override
    public List<Long> getNumeros(Employe e) {
        return entrees.get(e);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Employe, List<Long>> entry : entrees.entrySet()) {
            sb.append(entry.getKey())
              .append(" → ")
              .append(entry.getValue())
              .append('\n');
        }
        return sb.toString();
    }
}
