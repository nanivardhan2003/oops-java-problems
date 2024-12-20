package IN;
import java.util.*;
public class fifth {
	private static final List<String> stations = Arrays.asList(
	        "Chennai Beach", "Chennai Fort", "Chennai Park", "Chennai Egmore",
	        "Chetpet", "Nungambakkam", "Kodambakkam", "Mambalam", "Saidapet",
	        "Guindy", "St. Thomas Mount", "Pazhavanthangal", "Meenambakkam",
	        "Trisulam", "Pallavaram", "Chromepet", "Tambaram Sanatorium", "Tambaram"
	    );
	    private static int calculatePrice(int stationsTraveled) {
	        if (stationsTraveled == 17) {
	            return 20; 
	        } else if (stationsTraveled <= 5) {
	            return 10;
	        } else {
	            return 10 + ((stationsTraveled - 5 + 4) / 5) * 5; 
	        }
	    }
	    private static void printTicket(String start, String end, int stops, int price) {
	        System.out.println(start);
	        System.out.println(end);
	        System.out.println(stops + " Stops");
	        System.out.println("₹" + price);
	    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String startStation = sc.nextLine();
        String endStation = sc.nextLine();
        if (!stations.contains(startStation) || !stations.contains(endStation)) {
            System.out.println("Invalid station name. Please try again.");
            return;
        }
        int startIndex = stations.indexOf(startStation);
        int endIndex = stations.indexOf(endStation);
        int stops = Math.abs(endIndex - startIndex);
        int price = calculatePrice(stops);
        printTicket(startStation, endStation, stops, price);
}
}
