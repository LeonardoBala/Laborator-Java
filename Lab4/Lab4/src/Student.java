public class Student extends Person {
    private int[] grades;

    // Constructor
    public Student(String name, String email, int[] grades) {
        super(name, email);
        this.grades = grades;
    }

    // Getter pentru proprietatea "grades"
    public int[] getGrades() {
        return grades;
    }

    // Setter pentru proprietatea "grades"
    public void setGrades(int[] grades) {
        this.grades = grades;
    }
}
