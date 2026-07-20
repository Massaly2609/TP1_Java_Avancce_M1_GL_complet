package sn.uasz.m1.tp1.exo2;

/**
 * Programme principal de test de la classe Operation.
 *
 * Compilation/exécution :
 *   javac sn/uasz/m1/tp1/exo2/TestOperation.java
 *   java  sn.uasz.m1.tp1.exo2.TestOperation
 */
public class TestOperation {

    public static void main(String[] args) {

        Operation op1 = new Operation(10, 3);     // cas normal
        Operation op2 = new Operation(5, 0);      // division par 0
        Operation op3 = new Operation(-4, 1);     // somme négative
        Operation op4 = new Operation(12, -2);    // négatif → estDivisible illégal

        System.out.println("=== Test : quotient ===");
        tryOp(() -> System.out.println("10/3 = " + op1.quotient()));
        tryOp(() -> System.out.println("5/0  = " + op2.quotient()));

        System.out.println("\n=== Test : racineDeLaSomme ===");
        tryOp(() -> System.out.println("√(10+3) = " + op1.racineDeLaSomme()));
        tryOp(() -> System.out.println("√(-4+1) = " + op3.racineDeLaSomme()));

        System.out.println("\n=== Test : estDivisible ===");
        tryOp(() -> System.out.println("10 divisible par 3 ? " + op1.estDivisible()));
        tryOp(() -> System.out.println("12 divisible par -2 ? " + op4.estDivisible()));
    }

    /** Petit utilitaire pour factoriser le pattern try / catch. */
    @FunctionalInterface
    private interface RunnableEx { void run() throws OperationException; }

    private static void tryOp(RunnableEx action) {
        try {
            action.run();
        } catch (OperationException e) {
            System.out.println("⚠ " + e.getMessage());
        }
    }
}
