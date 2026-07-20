package sn.uasz.m1.tp1.exo2;

/**
 * TP1 - Exercice 2
 * Classe Operation munie d'opérations arithmétiques pouvant lever
 * une OperationException si les valeurs ne sont pas valides.
 */
public class Operation {

    // ---- Attributs privés (encapsulation) ----
    private int a;
    private int b;

    // ---- Constructeurs ----

    /** Constructeur par défaut : a = b = 0. */
    public Operation() {
        this(0, 0);
    }

    /** Constructeur d'initialisation. */
    public Operation(int a, int b) {
        this.a = a;
        this.b = b;
    }

    // ---- Getters / setters ----
    public int getA() { return a; }
    public int getB() { return b; }
    public void setA(int a) { this.a = a; }
    public void setB(int b) { this.b = b; }

    /**
     * Renvoie le quotient a / b.
     * @throws OperationException si b vaut 0.
     */
    public double quotient() throws OperationException {
        if (b == 0) {
            throw new OperationException(
                "Division impossible : le second attribut vaut 0");
        }
        return (double) a / b;
    }

    /**
     * Renvoie la racine carrée de (a + b) si cette somme est >= 0.
     * @throws OperationException si la somme est strictement négative.
     */
    public double racineDeLaSomme() throws OperationException {
        int somme = a + b;
        if (somme < 0) {
            throw new OperationException(
                "Racine carrée impossible : somme négative (" + somme + ")");
        }
        return Math.sqrt(somme);
    }

    /**
     * Indique si a est divisible par b.
     * @throws OperationException si a <= 0 ou b <= 0.
     */
    public boolean estDivisible() throws OperationException {
        if (a <= 0 || b <= 0) {
            throw new OperationException(
                "Divisibilité impossible : a et b doivent être > 0 (a=" + a + ", b=" + b + ")");
        }
        return (a % b) == 0;
    }

    @Override
    public String toString() {
        return "Operation[a=" + a + ", b=" + b + "]";
    }
}
