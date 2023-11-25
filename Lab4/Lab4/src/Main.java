// Lab 4 Bala Leonardo
import java.util.Locale;
import java.util.Scanner;

// Main
public class Main {
    public static void main(String[] args) {
        Scanner S_input = new Scanner(System.in);
        int scelta;

        System.out.println("Exerciti:\n 1- Mijlocul unui cuvant\n 2- Suma cifre numar\n 3- Dog\n 4- Rectangle\n 5- Persoana");

        do {
            System.out.println("\nCe solutie doriti sa efectuati ?:");
            scelta = S_input.nextInt();
            S_input.nextLine();

            switch (scelta) {
                case 1:
                    System.out.println("Introduceți un cuvânt:");
                    String cuvant = S_input.nextLine().trim();
                    Mijloc(cuvant);
                    break;
                case 2:
                    System.out.println("Introduceți un numar:");
                    int numar = S_input.nextInt();
                    System.out.println("Suma cifrelor lui " + numar + " este: " + Suma_Cif(numar));
                    break;
                case 3:
                    // Creare istante
                    Dog dog1 = new Dog("Buddy", "Labrador");
                    Dog dog2 = new Dog("Max", "Beagle");

                    // Afisare informații initiale
                    afiseazaInformatii(dog1, "Initial");
                    afiseazaInformatii(dog2, "Initial");

                    // Modificare
                    dog1.setName("Charlie");
                    dog1.setBreed("Golden Retriever");

                    dog2.setName("Rocky");
                    dog2.setBreed("German Shepherd");

                    // Afisare informatii
                    afiseazaInformatii(dog1, "Dupa modificari");
                    afiseazaInformatii(dog2, "Dupa modificari");
                    break;
                case 4:
                    Rectangle b = new Rectangle(20,30);
                    System.out.println(b);
                    break;
                case 5:
                    // Crem Student si Profesor
                    int[] grades = {90, 85, 92, 78};
                    Student student = new Student("John Doe", "john.doe@example.com", grades);

                    String[] courses = {"Matematica", "Informatica", "Fizica"};
                    Profesor profesor = new Profesor("Prof. Smith", "smith@example.com", courses);

                    // Afisare informati Student
                    System.out.println("Student:");
                    System.out.println("Nume: " + student.getName());
                    System.out.println("Email: " + student.getEmail());
                    System.out.print("Note: ");
                    for (int grade : student.getGrades()) {
                        System.out.print(grade + " ");
                    }
                    System.out.println("\n");

                    // Afisare informati Profesor
                    System.out.println("Profesor:");
                    System.out.println("Nume: " + profesor.getName());
                    System.out.println("Email: " + profesor.getEmail());
                    System.out.print("Cursuri predate: ");
                    for (String course : profesor.getCourses()) {
                        System.out.print(course + " ");
                    }
                    break;
            }
        } while (scelta != 0);

        S_input.close();
    }

    // Clasa cuvant mijloc
    public static void Mijloc(String cuvant){
        cuvant = cuvant.toLowerCase();
        int lungime = cuvant.length();

        if (lungime % 2 == 0) {
            // Par
            int jumatate = lungime / 2;
            System.out.println("Caracterele din mijloc sunt: " + cuvant.charAt(jumatate - 1) + cuvant.charAt(jumatate));
        } else {
            // Impar
            int mijloc = lungime / 2;
            System.out.println("Caracterul din mijloc este: " + cuvant.charAt(mijloc));
        }
    }

    // Clasa SUma_Cif
    public static int Suma_Cif(int numar){
        int suma =0;

        while (numar != 0) {
            suma += numar % 10;
            numar /= 10;
        }

        return suma;
    }

    // Functia pentru afisa informatile
    private static void afiseazaInformatii(Dog dog, String status) {
        System.out.println(status + " - Nume: " + dog.getName() + ", Rasa: " + dog.getBreed());
    }

}

