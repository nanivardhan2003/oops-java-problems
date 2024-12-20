package IN;
import java.util.*;
class Driver {
    String name;
    String carModel;
    double rating;
    int distanceFromCustomer; 
    public Driver(String name, String carModel, double rating, int distanceFromCustomer) {
        this.name = name;
        this.carModel = carModel;
        this.rating = rating;
        this.distanceFromCustomer = distanceFromCustomer;
    }
}
public class ride {
	private static final int CHARGE_PER_KM = 8;
    public static Driver findDriver(List<Driver> drivers, String requestedCarModel) {
        Driver selectedDriver = null;
        for (Driver driver : drivers) {
            if (driver.rating >= 4 && driver.carModel.equalsIgnoreCase(requestedCarModel)) {
                if (selectedDriver == null || driver.distanceFromCustomer < selectedDriver.distanceFromCustomer) {
                    selectedDriver = driver;
                }
            }
        }

        return selectedDriver; 
    }
    public static int calculateCharge(int distanceInKm) {
        return distanceInKm * CHARGE_PER_KM;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter Customer Ride Distance (in km): ");
        int rideDistance = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter Requested Car Model: ");
        String requestedCarModel = sc.nextLine();
        List<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver("A", "Sedan", 4.0, 500));
        drivers.add(new Driver("B", "HatchBack", 4.3, 1000));
        drivers.add(new Driver("C", "5 Seater", 4.8, 200));
        drivers.add(new Driver("D", "Sedan", 4.1, 700));
        drivers.add(new Driver("E", "HatchBack", 4.7, 430));
        Driver assignedDriver = findDriver(drivers, requestedCarModel);

        if (assignedDriver != null) {
            int totalCharge = calculateCharge(rideDistance);
            System.out.println("Driver " + assignedDriver.name + " will get you to the destination.");
            System.out.println("Your charge will be Rs " + totalCharge + " (" + rideDistance + " * " + CHARGE_PER_KM + ").");
        } else {
            System.out.println("No drivers available for the requested car model. Please select another car model.");
        }
	}

}
