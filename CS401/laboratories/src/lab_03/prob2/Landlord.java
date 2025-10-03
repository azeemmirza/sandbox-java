package lab_03.prob2;

import java.util.ArrayList;
import java.util.List;

public class Landlord {
    private int id;
    private List<Building> buildings;

    public Landlord(int id) {
        this.id = id;
        this.buildings = new ArrayList<>();
    }

    public double getTotalMonthlyProfit() {
        return buildings.stream()
                .mapToDouble(Building::getProfit)
                .sum();
    }
    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public int getId() {
        return id;
    }
}
