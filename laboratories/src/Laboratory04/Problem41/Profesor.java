package Laboratory04.Problem41;

public class Profesor extends DeptEmployee {
    private int numberOfPublications;

    public Profesor(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);

    }

    public int getNumberOfPublications() {
        return numberOfPublications;
    }
    public void setnumberOfPublications(int numberOfPublications) {
        this.numberOfPublications = numberOfPublications;
    }





}
