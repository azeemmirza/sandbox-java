package Assignment3.labs.prob3;


public non-sealed class House extends Property {
    private double lotSize;

    public House(Address address, double lotSize) {
        setAddress(address);
        this.lotSize = lotSize;
    }

    @Override
    public double computeRent() {
        return 0.1 * lotSize;
    }
}
