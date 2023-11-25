/*Bala Leonardo Lab3 Ex1*/
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String[] a = {"java","test","university"};
        String[] b = {"car","university","plane"};

        // Parcurgeți fiecare element din primul tablou
        for (String element1 : a) {
            // Parcurgeți fiecare element din al doilea tablou
            for (String element2 : b) {
                // Comparați elementele
                if (element1.equals(element2)) {
                    // Dacă sunt egale, tipăriți elementul
                    System.out.println("Element comun: " + element1);
                }
            }
        }
    }
}
