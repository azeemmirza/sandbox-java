package Assignment3.labs.prob3;


public non-sealed class Trailer extends Property {
    private static final double RENT = 500;

    public Trailer(Address address) {
        setAddress(address);
    }

    @Override
    public double computeRent() {
        return RENT;
    }
}
