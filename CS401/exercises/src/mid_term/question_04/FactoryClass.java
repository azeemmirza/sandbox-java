package mid_term.question_04;

public class FactoryClass {
  
  public Person createPerson(int id, String firstName, String lastName) {
    return new Person(id, firstName, lastName);
  }

  public Vehicle createVehicle(String model, String regNo) {
    return new Vehicle(model, regNo);
  }

  public void assignOwnerToVehicle(Vehicle veh, Person owner) {
    veh.assignOwner(owner);
    owner.addVehicle(veh);
  }
}
