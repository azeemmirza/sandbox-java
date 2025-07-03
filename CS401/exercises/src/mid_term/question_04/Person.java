package mid_term.question_04;

import java.util.*;

public class Person {
  private int id; 
  private String firstName;
  private String lastName;
  private List<Vehicle> vehicles;


  public Person(int id, String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.vehicles = new ArrayList<Vehicle>();
  }

  public void addVehicle(Vehicle vehicle) {
    this.vehicles.add(vehicle);
  }
}
