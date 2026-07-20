package sn.uasz.m1.tp1.exo1;

/**
 * TP1 - Exercice 1 : analyse de programme.
 * Sortie attendue :
 *   Capture d'exception de type Exception1
 *   Capture d'exception de type Exception2
 *   Capture d'exception de type Exception3
 *   Capture d'exception de type Exception
 */
class Exception1 extends Exception {
    Exception1(String s) { super(s); }
}
class Exception2 extends Exception {
    Exception2(String s) { super(s); }
}
class Exception3 extends Exception1 {
    Exception3(String s) { super(s); }
}

public class TestException {

    public static void verifie(int i) throws Exception {
        switch (i) {
            case 1: throw new Exception1("exception de type Exception1");
            case 2: throw new Exception2("exception de type Exception2");
            case 3: throw new Exception3("exception de type Exception3");
            default: throw new Exception("exception de type Exception");
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i < 5; i++) {
            try {
                verifie(i);
            } catch (Exception3 e) {
                System.out.println("Capture d'" + e.getMessage());
            } catch (Exception1 e) {
                System.out.println("Capture d'" + e.getMessage());
            } catch (Exception e) {
                System.out.println("Capture d'" + e.getMessage());
            }
        }
    }
}
