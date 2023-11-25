import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cere utilizatorului să introducă numărul de elemente
        System.out.print("Cate elemente doriti sa introduceti: ");
        int n = scanner.nextInt();

        // Inițializare tablou
        int[] array = new int[n];

        // Cere utilizatorului să introducă fiecare element al tabloului
        System.out.println("Introduceți elementele tabloului:");

        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (esteNumarPrim(array[i])) {
                System.out.println(array[i] + " este un număr prim.");
            }
        }

        // Închide scanner-ul pentru a evita scurgeri de resurse
        scanner.close();
    }

    // Metodă pentru a verifica dacă un număr este prim
    private static boolean esteNumarPrim(int numar) {
        if (numar <= 1) {
            return false; // Numerele mai mici sau egale cu 1 nu sunt prime
        }

        // Verificăm divizibilitatea numărului până la rădăcina sa pătrată
        for (int i = 2; i <= Math.sqrt(numar); i++) {
            if (numar % i == 0) {
                return false; // Dacă găsim un divizor, numărul nu este prim
            }
        }

        return true; // Dacă nu am găsit divizori, numărul este prim
    }
}

