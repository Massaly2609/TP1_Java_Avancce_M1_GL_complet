  # TP Java Avancé — Master 1 UASZ

Solutions complètes des TP1 (Exceptions & Collections) et TP2 (Interfaces & Collections),
organisées sous le package racine `sn.uasz.m1.tp1`.

## Arborescence

```
TP_Java/
├── README.md
├── compiler.sh          (Linux / macOS)
├── compiler.bat         (Windows)
└── src/
    └── sn/uasz/m1/tp1/
        ├── exo1/   TestException.java
        ├── exo2/   Operation, OperationException, TestOperation
        ├── exo3/   Employe, GestionEmploye
        ├── exo4/   Sexe, IdentifiantExistantException,
        │           InexistantMembreException, Membre, Club, GestionClub
        ├── exo5/   Carburant, PlaceInexistanteException,
        │           PlaceOccupeeException, PlaceNonOccupeeException,
        │           Voiture, Parking, GestionParking
        ├── exo6/   ManipTexte, TestManipTexte
        ├── exo7/   Pile, EmptyPileException, PileList, TestPile
        └── collection/
            ├── Civilite, Annuaire, Employe, UnAnnuaire
            └── test/   TestAnnuaire
```

## Compilation

Depuis le dossier `TP_Java/src` :

```bash
# Tout compiler d'un coup
javac -d ../out $(find . -name "*.java")

# Ou un fichier précis (les dépendances seront résolues automatiquement)
javac sn/uasz/m1/tp1/exo2/TestOperation.java
```

## Exécution

Toujours depuis `TP_Java/src` (ou depuis `out` si vous avez utilisé `-d ../out`) :

```bash
java sn.uasz.m1.tp1.exo1.TestException
java sn.uasz.m1.tp1.exo2.TestOperation
java sn.uasz.m1.tp1.exo3.GestionEmploye
java sn.uasz.m1.tp1.exo4.GestionClub
java sn.uasz.m1.tp1.exo5.GestionParking
java sn.uasz.m1.tp1.exo6.TestManipTexte
java sn.uasz.m1.tp1.exo7.TestPile
java sn.uasz.m1.tp1.collection.test.TestAnnuaire
```

## Dans un IDE (Eclipse / IntelliJ / VS Code)

1. Créez un nouveau projet Java.
2. Ajoutez le dossier `src` comme **source root**.
3. Le compilateur prendra automatiquement en charge la structure de packages.
4. Faites clic droit sur n'importe quelle classe contenant `main(String[])` → *Run*.

## Prérequis

- JDK 11 ou plus récent (le code utilise `var` dans certaines portions mais reste
  compatible JDK 8 ; testé avec JDK 17).

## Points pédagogiques importants

- **TP1, Exo 2 — Operation** : illustre la création d'exceptions personnalisées
  héritant de `Exception`.
- **TP1, Exo 4 — Club** : `equals`/`hashCode` redéfinis pour qu'un membre puisse
  servir de clé dans une `HashMap`.
- **TP1, Exo 5 — Parking** : `Map<Integer, Voiture>` pour associer place → voiture
  avec gestion de plusieurs exceptions personnalisées.
- **TP1, Exo 7 — PileList** : implémenter une interface (LIFO) en utilisant une
  `ArrayList` comme structure interne.
- **TP2, Exo 8 — Annuaire** : démonstration du contrat
  `equals` + `hashCode` (HashMap) puis `Comparable` (TreeMap), avec leurs
  conséquences pratiques.
