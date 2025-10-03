package lab_03.prob4;

public abstract sealed class Property permits House, Trailer, Condo {
    private Address address;

    public abstract double computeRent();

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
