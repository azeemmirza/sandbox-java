package lab_03.prob2;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private final int id;
    private final List<Apartment> apartments;
    private final int maintenanceCost;

    public Building(int id, int maintenanceCost) {
        this.id = id;
        this.apartments = new ArrayList<>();
        this.maintenanceCost = maintenanceCost;
    }

    public double getProfit() {
        return apartments.stream()
                .mapToDouble(Apartment::getRent)
                .sum() - maintenanceCost;
    }
    public void addApartment(Apartment ap) {
        apartments.add(ap);
    }

    public int getId() {
        return id;
    }
}
