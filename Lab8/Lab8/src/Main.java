import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner S_input = new Scanner(System.in);
        int scelta;
        // ArrayList persone
        List<Persona> listaPersone = new ArrayList<>();

        System.out.println("Eserciti:\n 1- Prima\n 2- doi\n 3- trei");

        do {
            System.out.println("\nChe soluzione desiderate effettuare?:");
            scelta = S_input.nextInt();
            S_input.nextLine();

            switch (scelta) {
                case 1:
                    System.out.println("Quante persone desiderate inserire?");
                    int numar_Persone = S_input.nextInt();

                    for (int i = 0; i < numar_Persone; i++) {
                        Aggiungi_Persone(listaPersone);
                    }

                    Elimina_Doppi(listaPersone);

                    break;
                case 2:
                    // Aggiungere il codice per la soluzione 2
                    List<String> listaStringhe = new ArrayList<>();
                    listaStringhe.add("albero");
                    listaStringhe.add("cane");
                    listaStringhe.add("cucina");
                    listaStringhe.add("array");
                    listaStringhe.add("bosco");

                    System.out.println("Introdu caracterul: ");
                    char startingLetter = S_input.next().charAt(0);

                    long ctr = listaStringhe.stream()
                               .filter(s -> s.startsWith(String.valueOf(startingLetter)))
                               .count();
                    System.out.println("\nNumber of Strings starting with '" + startingLetter + "': " + ctr);

                    break;
                case 3:
                    List<String> dueponti = new ArrayList<>();
                    dueponti.add("albero");
                    dueponti.add("cane");
                    dueponti.add("cucina");
                    dueponti.add("array");
                    dueponti.add("bosco");

                    // Ordinamento in ordine ascendente
                    List<String> ordinataAscendente = dueponti.stream()
                            .sorted()
                            .collect(Collectors.toList());

                    System.out.println("Lista ordinata in ordine ascendente:");
                    System.out.println(ordinataAscendente);

                    // Ordinamento in ordine discendente
                    List<String> ordinataDiscendente = dueponti.stream()
                            .sorted(Collections.reverseOrder())
                            .collect(Collectors.toList());

                    System.out.println("Lista ordinata in ordine discendente:");
                    System.out.println(ordinataDiscendente);
                    break;
            }
        } while (scelta != 0);

        S_input.close();
    }

    public static void Aggiungi_Persone(List<Persona> listaPersone) {
        System.out.println("Aggiungi nome e anni: ");
        Scanner S_input = new Scanner(System.in);
        String nome = S_input.nextLine().trim();
        int anni = S_input.nextInt();

        // Aggiunta di persone alla lista
        listaPersone.add(new Persona(nome, anni));
    }

    public static void Elimina_Doppi(List<Persona> listaPersone) {
        List<Persona> listWithoutDuplicateValuesWithStream =
                listaPersone
                        .stream()
                        .distinct()
                        .collect(Collectors.toList());

        System.out.println("Dati attuali: " + listaPersone);
        System.out.println("Dopo la rimozione dei duplicati: " + listWithoutDuplicateValuesWithStream);
    }

    static class Persona {
        String nome;
        int anni;

        public Persona(String nome, int anni) {
            this.nome = nome;
            this.anni = anni;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Persona persona = (Persona) o;
            return anni == persona.anni &&
                    nome.equals(persona.nome);
        }

        @Override
        public int hashCode() {
            return nome.hashCode() + Integer.hashCode(anni);
        }

        @Override
        public String toString() {
            return "Persona{" +
                    "nome='" + nome + '\'' +
                    ", anni=" + anni +
                    '}';
        }
    }
}
