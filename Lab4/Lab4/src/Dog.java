public class Dog {
    private String name;
    private String breed;

    // Constructor care initializează proprietățile
    public Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    // Getter pentru proprietatea "name"
    public String getName() {
        return name;
    }

    // Setter pentru proprietatea "name"
    public void setName(String name) {
        this.name = name;
    }

    // Getter pentru proprietatea "breed"
    public String getBreed() {
        return breed;
    }

    // Setter pentru proprietatea "breed"
    public void setBreed(String breed) {
        this.breed = breed;
    }
}
