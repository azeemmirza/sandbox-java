package Assignment3.labs.prob3;


public non-sealed class Condo extends Property {
    private int numberOfFloors;


    public Condo(Address address, int numberOfFloors) {
        setAddress(address);
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public double computeRent() {
        return 500 * numberOfFloors;
    }
}
