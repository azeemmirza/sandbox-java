package lab_03.prob4;


public non-sealed class Condo extends Property {
    private final int numberOfFloors;

    public Condo(Address address, int numberOfFloors) {
        setAddress(address);
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public double computeRent() {
        return 500 * numberOfFloors;
    }
}
