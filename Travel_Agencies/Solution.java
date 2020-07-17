import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TravelAgencies[] ta = new TravelAgencies[4];
        for (int i = 0; i < ta.length; i++) {
            int regNo = sc.nextInt();
            sc.nextLine();
            String agencyName = sc.nextLine();
            String packageType = sc.nextLine();
            int price = sc.nextInt();
            boolean flightFacility = sc.nextBoolean();
            ta[i] = new TravelAgencies(regNo, agencyName, packageType, price, flightFacility);
        }

        int getRegNo = sc.nextInt();
        sc.nextLine();
        String getPackageType = sc.nextLine();
        sc.close();

        int highestPackagePrice = findAgencyWithHighestPackagePrice(ta);
        TravelAgencies travelAgencies = agencyDetailsForGivenIdAndType(ta, getRegNo, getPackageType);

        System.out.println(highestPackagePrice);
        if (travelAgencies == null)
            System.out.println("A string value should be printed here!");
        else
            System.out.println(travelAgencies.getAgencyName() + ":" + travelAgencies.getPrice());
    }
    public static int findAgencyWithHighestPackagePrice(TravelAgencies[] agencies) {
        int maxPrice = agencies[0].getPrice();
        for (int i = 1; i < agencies.length; i++) {
            if (agencies[i].getPrice() > maxPrice)
                maxPrice = agencies[i].getPrice();
        }
        return maxPrice;
    }
    public static TravelAgencies agencyDetailsForGivenIdAndType(TravelAgencies[] agencies, int regNo, String packageType) {
        for (int i = 0; i < agencies.length; i++) {
            if (agencies[i].getFlightFacility()) {
                if (agencies[i].getRegNo() == regNo && packageType.equalsIgnoreCase(agencies[i].getPackageType())) {
                    return agencies[i];
                }
            }
        }
        return null;
    }
}

class TravelAgencies {
    int regNo;
    String agencyName;
    String packageType;
    int price;
    boolean flightFacility;
    TravelAgencies(int regNo, String agencyName, String packageType, int price, boolean flightFacility) {
        this.regNo = regNo;
        this.agencyName = agencyName;
        this.packageType = packageType;
        this.price = price;
        this.flightFacility = flightFacility;
    }
    int getRegNo() {
        return regNo;
    }
    String getAgencyName() {
        return agencyName;
    }
    String getPackageType() {
        return packageType;
    }
    int getPrice() {
        return price;
    }
    boolean getFlightFacility() {
        return flightFacility;
    }
}