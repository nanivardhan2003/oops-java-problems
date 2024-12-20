package IN;
import java.util.*;
class GoFoodOrder {
    private static final Map<String, Integer> menu = new HashMap<>();
    private static final int PEAK_HOUR_CHARGE = 30;
    private static final int SPECIAL_DAY_CHARGE = 50;
    private static final int NIGHT_CHARGE = 20;
    private static final int NORMAL_DELIVERY_CHARGE = 20;
    private static final double GST = 0.05;
    static {
        menu.put("Pizza", 150);
        menu.put("Burger", 100);
        menu.put("Coke", 50);
        menu.put("Brownies", 60);
    }

    private boolean isSpecialDay;
    private boolean isPeakHour;
    private boolean isNightOrder;
    private List<String> items;
    public GoFoodOrder(boolean isSpecialDay, boolean isPeakHour, boolean isNightOrder, List<String> items) {
        this.isSpecialDay = isSpecialDay;
        this.isPeakHour = isPeakHour;
        this.isNightOrder = isNightOrder;
        this.items = items;
    }
    public double calculateTotalBill() {
        int itemCost = 0;
        for (String item : items) {
            itemCost += menu.getOrDefault(item, 0);
        }
        int deliveryCharge = 0;
        if (isSpecialDay) {
            deliveryCharge = SPECIAL_DAY_CHARGE;
        } else if (isNightOrder) {
            deliveryCharge = NIGHT_CHARGE;
        } else if (isPeakHour) {
            deliveryCharge = PEAK_HOUR_CHARGE;
        } else {
            deliveryCharge = NORMAL_DELIVERY_CHARGE;
        }
        double gst = itemCost * GST;
        return itemCost + deliveryCharge + gst;
    }
}

public class third {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        //System.out.print("Is it a Special Day? (yes/no): ");
	        boolean isSpecialDay = sc.nextLine().equalsIgnoreCase("yes");
	        //System.out.print("Is it Peak Hour? (yes/no): ");
	        boolean isPeakHour = sc.nextLine().equalsIgnoreCase("yes");
	        //System.out.print("Is it a Night Order? (yes/no): ");
	        boolean isNightOrder = sc.nextLine().equalsIgnoreCase("yes");

	        //System.out.print("Enter items (comma-separated): ");
	        String itemsInput = sc.nextLine();
	        List<String> items = Arrays.asList(itemsInput.split(","));
	        GoFoodOrder order = new GoFoodOrder(isSpecialDay, isPeakHour, isNightOrder, items);
	        double totalBill = order.calculateTotalBill();
	        System.out.printf("Total Bill: ₹%.2f%n", totalBill);

	}

}
