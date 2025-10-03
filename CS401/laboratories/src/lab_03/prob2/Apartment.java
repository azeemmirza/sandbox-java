package lab_03.prob2;

public class Apartment {
    private final int id;
    private final double rent;

    public Apartment(int id, double rent) {
        this.id = id;
        this.rent = rent;
    }

    public double getRent() {
        return rent;
    }

    public int getId() {
        return id;
    }
}