package lab_03.prob4;


public non-sealed class House extends Property {
    private final double lotSize;

    public House(Address address, double lotSize) {
        setAddress(address);
        this.lotSize = lotSize;
    }

    @Override
    public double computeRent() {
        return 0.1 * lotSize;
    }
}
