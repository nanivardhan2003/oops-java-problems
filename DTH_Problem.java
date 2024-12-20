package IN;
import java.util.*;
class Channel {
    private String name;
    private int price;

    public Channel(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

class Package {
    private String name;
    private int price;
    private List<String> channels;

    public Package(String name, int price, List<String> channels) {
        this.name = name;
        this.price = price;
        this.channels = channels;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public List<String> getChannels() {
        return channels;
    }
}
public class second {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        Map<String, Channel> channels = new HashMap<>();
	        channels.put("HBO Movies", new Channel("HBO Movies", 10));
	        channels.put("KTV", new Channel("KTV", 12));
	        channels.put("Zee News", new Channel("Zee News", 2));
	        channels.put("NDTV News", new Channel("NDTV News", 5));
	        channels.put("Fox", new Channel("Fox", 10));
	        List<Package> packages = new ArrayList<>();
	        packages.add(new Package("English Pack", 12, Arrays.asList("HBO Movies", "NDTV News")));
	        packages.add(new Package("News Pack", 5, Arrays.asList("NDTV News", "Zee News")));
	        System.out.print("Choose packages :");
	        String[] selectedPackages = sc.nextLine().split(",");
	        System.out.print("Choose channels :");
	        String[] selectedChannels = sc.nextLine().split(",");
	        Set<String> selectedChannelNames = new HashSet<>();
	        int totalCost = 0;
	        for (String packageName : selectedPackages) {
	            for (Package pack : packages) {
	                if (pack.getName().equalsIgnoreCase(packageName.trim())) {
	                    totalCost += pack.getPrice();
	                    selectedChannelNames.addAll(pack.getChannels());
	                }
	            }
	        }
	        for (String channelName : selectedChannels) {
	            if (!selectedChannelNames.contains(channelName.trim()) && channels.containsKey(channelName.trim())) {
	                totalCost += channels.get(channelName.trim()).getPrice();
	                selectedChannelNames.add(channelName.trim());
	            }
	        }
	        System.out.println("Total Cost: " + totalCost);
	}

}
