package IN;
import java.util.*;
class CarService {
    private static final Map<String, Map<String, Integer>> serviceRates = new HashMap<>();
    static {
        Map<String, Integer> hatchbackRates = new HashMap<>();
        hatchbackRates.put("BS01", 2000);
        hatchbackRates.put("EP01", 5000);
        hatchbackRates.put("CP01", 2000);
        hatchbackRates.put("BF01", 1000);
        hatchbackRates.put("GP01", 3000);
        serviceRates.put("Hatchback", hatchbackRates);

        Map<String, Integer> sedanRates = new HashMap<>();
        sedanRates.put("BS01", 4000);
        sedanRates.put("EP01", 8000);
        sedanRates.put("CP01", 4000);
        sedanRates.put("BF01", 1500);
        sedanRates.put("GP01", 6000);
        serviceRates.put("Sedan", sedanRates);

        Map<String, Integer> suvRates = new HashMap<>();
        suvRates.put("BS01", 5000);
        suvRates.put("EP01", 10000);
        suvRates.put("CP01", 6000);
        suvRates.put("BF01", 2500);
        suvRates.put("GP01", 8000);
        serviceRates.put("SUV", suvRates);
    }

    private String carType;
    private List<String> serviceCodes;

    public CarService(String carType, List<String> serviceCodes) {
        this.carType = carType;
        this.serviceCodes = serviceCodes;
    }

    public int calculateTotalBill() {
        int totalBill = 0;
        Map<String, Integer> rates = serviceRates.get(carType);

        if (rates == null) {
            System.out.println("Invalid car type: " + carType);
            return totalBill;
        }

        for (String code : serviceCodes) {
            if (rates.containsKey(code)) {
                totalBill += rates.get(code);
            } else {
                System.out.println("Invalid service code: " + code);
            }
        }

        return totalBill;
    }
}
public class fourth {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String carType = sc.nextLine();
        String serviceInput = sc.nextLine();
        List<String> serviceCodes = Arrays.asList(serviceInput.split(","));
        CarService carService = new CarService(carType, serviceCodes);
        int totalBill = carService.calculateTotalBill();
        System.out.println("Total bill:" + totalBill);

	}

}
