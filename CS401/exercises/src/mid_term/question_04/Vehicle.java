package mid_term.question_04;

public class Vehicle {
    private String model;
    private String registrationNumber;
    private Person owner;

    public Vehicle(String model, String registrationNumber) {
        this.model = model;
        this.registrationNumber = registrationNumber;
    }

    public void assignOwner(Person owner) {
        if (this.owner != null) {
            throw new IllegalArgumentException("vehicle already has a owner");
        }

        this.owner = owner;
    }
}
