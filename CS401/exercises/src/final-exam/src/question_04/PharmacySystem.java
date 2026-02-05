import java.util.*;

class Medication {
    private final String name;
    public Medication(String name) { this.name = name; }
    public String getName() { return name; }
}

class Painkiller extends Medication {
    public Painkiller(String name) { super(name); }
}

class Antibiotic extends Medication {
    public Antibiotic(String name) { super(name); }
}

public class PharmacySystem {

    public static void main(String[] args) {
        List<Medication> meds = Arrays.asList(
                new Medication("Saline"),
                new Medication("Vitamin C")
        );

        List<Painkiller> painkillers = new ArrayList<>(
                Arrays.asList(
                        new Painkiller("Ibuprofen"),
                        new Painkiller("Aspirin")
                )
        );

        List<Antibiotic> antibiotics = Arrays.asList(
                new Antibiotic("Amoxicillin")
        );

        printMedicationNames(meds);
        printMedicationNames(painkillers);
        printMedicationNames(antibiotics);

        addPainkillers(painkillers);
    }

    public static void printMedicationNames(List<? extends Medication> meds) {
        for (Medication med : meds) {
            System.out.println(med.getName());
        }
    }

    public static void addPainkillers(List<? super Painkiller> painkillerList) {
        painkillerList.add(new Painkiller("Ibuprofen"));
        painkillerList.add(new Painkiller("Acetaminophen"));
        painkillerList.add(new Painkiller("Aspirin"));
    }
}