package lab_03.prob2;

/** 
 * Main class is for testing your code; you can uncomment
 * the code here once you have implemented classes. 
 * 
 * However, the way
 * data has been populated into the LandlordInfo and Building
 * objects violates the design indicated in the UML diagram for
 * this problem. Refactor the code in the main method so that
 * data is loaded in a correct manner; you can verify that you
 * have done this successfully by moving the Main class into a
 * different package.
 *
 */
public class Main {

    public static void main(String[] args) {
        Apartment[] apts0 = {
                new Apartment(1, 600),
                new Apartment(11, 700)};

        Apartment[] apts1 = {
                new Apartment(2, 500),
                new Apartment(22, 450)};

        Apartment[] apts2 = {
                new Apartment(3, 1100),
                new Apartment(33, 650)};

        Apartment[] apts3 = {
                new Apartment(4, 6750),
                new Apartment(44, 945)};

        Building[] bldgs = {
                new Building(150, 400),
                new Building(175, 900),
                new Building(150, 300),
                new Building(175, 775)};

        for (Apartment a : apts0) {
            bldgs[0].addApartment(a);
        }
        for (Apartment a : apts1) {
            bldgs[1].addApartment(a);
        }
        for (Apartment a : apts2) {
            bldgs[2].addApartment(a);
        }
        for (Apartment a : apts3) {
            bldgs[3].addApartment(a);
        }

        Landlord landlord = new Landlord(12);
        for (Building b : bldgs) {
            landlord.addBuilding(b);
        }

        System.out.println(landlord.getTotalMonthlyProfit());
    }

}


