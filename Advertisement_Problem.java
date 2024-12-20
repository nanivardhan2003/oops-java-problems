package IN;
import java.util.Scanner;
abstract class Advertisement {
 protected String locationCode;
 protected int pricePerFrame;

 public Advertisement(String locationCode, int pricePerFrame) {
     this.locationCode = locationCode;
     this.pricePerFrame = pricePerFrame;
 }
 public abstract int calculateBill(int days);
}

class MetroRail extends Advertisement {
 private static final int MINIMUM_DAYS = 20;

 public MetroRail(String locationCode, int pricePerFrame) {
     super(locationCode, pricePerFrame);
 }

 @Override
 public int calculateBill(int days) {
     if (days < MINIMUM_DAYS) {
         System.out.println("Sorry, Minimum booking is " + MINIMUM_DAYS + " days for Metro.");
         return -1;
     }
     return days * pricePerFrame;
 }
}

class Bus extends Advertisement {
 private static final int MINIMUM_DAYS = 15;

 public Bus(String locationCode, int pricePerFrame) {
     super(locationCode, pricePerFrame);
 }

 @Override
 public int calculateBill(int days) {
     if (days < MINIMUM_DAYS) {
         System.out.println("Sorry, Minimum booking is " + MINIMUM_DAYS + " days for Bus.");
         return -1;
     }
     return days * pricePerFrame;
 }
}
public class first {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        System.out.print("Where to put ad? (Metro/Bus): ");
	        String s = sc.nextLine();
	        System.out.print("Location Code: ");
	        String locationCode = sc.nextLine();
	        System.out.print("Duration (in days): ");
	        int duration = sc.nextInt();
	        Advertisement obj = null;
	        if (s.equalsIgnoreCase("Metro")) {
	            switch (locationCode) {
	                case "IM01":
	                    obj = new MetroRail("IM01", 350);
	                    break;
	                case "OM01":
	                    obj = new MetroRail("OM01", 950);
	                    break;
	                case "AP01":
	                    obj = new MetroRail("AP01", 600);
	                    break;
	                default:
	                    System.out.println("Invalid Location Code for Metro.");
	                    return;
	            }
	        } else if (s.equalsIgnoreCase("Bus")) {
	            switch (locationCode) {
	                case "SB01":
	                    obj = new Bus("SB01", 550);
	                    break;
	                case "BB01":
	                    obj = new Bus("BB01", 800);
	                    break;
	                default:
	                    System.out.println("Invalid Location Code for Bus.");
	                    return;
	            }
	        } else {
	            System.out.println("Invalid ad type. Please choose 'Metro' or 'Bus'.");
	            return;
	        }
	        int billAmount = obj.calculateBill(duration);
	        if (billAmount != -1) {
	            System.out.println("Bill amount: " + billAmount);
	        }
	}
}
