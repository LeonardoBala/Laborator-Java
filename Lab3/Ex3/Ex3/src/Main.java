// Lab 3 Ex 3-4 Bala Leonardo
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner S_input = new Scanner(System.in);
        int scelta;

        System.out.println("Exerciti:\n 1- Fibonacci\n 2- Palindrom");

        do {
            System.out.println("\nCe solutie doriti sa efectuati ?:");
            scelta = S_input.nextInt();
            S_input.nextLine(); // Consuma completamente la riga

            switch (scelta) {
                case 1:
                    System.out.println("Introduceti numarul N pentru sirul Fibonacci:");
                    int n = S_input.nextInt();
                    S_input.nextLine(); // Consuma completamente la riga

                    System.out.println("Sirul Fibonacci pana la " + n + ":");
                    for (int i = 0; i < n; i++) {
                        if(Fibonacci(i) > n){
                            break;
                        } else {
                            System.out.print(Fibonacci(i) + " ");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Introduceți un cuvânt pentru a verifica dacă este palindrom:");
                    String cuvant = S_input.nextLine().trim(); // Rimuovi spazi vuoti
                    if (Palindrom(cuvant)) {
                        System.out.println(cuvant + " este un palindrom.");
                    } else {
                        System.out.println(cuvant + " nu este un palindrom.");
                    }
                    break;
            }
        } while (scelta != 0);

        S_input.close();
    }

    // Clasa Fiboncacci
    public static int Fibonacci(int n){

        if (n <= 1) {
            return n;
        } else {
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }

    }

    // Clasa cuvant palindrom
    public static boolean Palindrom(String cuvant){
        cuvant = cuvant.toLowerCase();
        int lungime_cuvant = cuvant.length();

        for (int i = 0; i < lungime_cuvant / 2; i++) {
            if (cuvant.charAt(i) != cuvant.charAt(lungime_cuvant - 1 - i)) {
                return false;
            }
        }

        return true;
    }

}

