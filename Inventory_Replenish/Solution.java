import java.util.Arrays;
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Inventory[] inventories = new Inventory[4];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < inventories.length; i++) {
            String inventoryId = sc.nextLine();
            int maximumQuantity = sc.nextInt();
            sc.nextLine();
            int currentQuantity = sc.nextInt();
            sc.nextLine();
            int threshold = sc.nextInt();
            sc.nextLine();
            inventories[i] = new Inventory(inventoryId, maximumQuantity, currentQuantity, threshold);
        }
        int limit = sc.nextInt();
        sc.close();
        Inventory[] result = replenish(inventories, limit);
        for (int i = 0; i < result.length; i++){
            if (result[i].getThreshold() >= 75)
                System.out.println(result[i].getInventoryId() + " Critical Filling");
            else if (result[i].getThreshold() >= 50 && result[i].getThreshold() <= 74)
                System.out.println(result[i].getInventoryId() + " Moderate Filling");
            else
                System.out.println(result[i].getInventoryId() + " Non-Critical Filling");
        }
    }
    public static Inventory[] replenish(Inventory[] inventories, int limit){
        Inventory[] refined = new Inventory[0];
        for (int i = 0; i < inventories.length; i++){
            if (inventories[i].getThreshold() <= limit){
                refined=Arrays.copyOf(refined, refined.length+1);
                refined[refined.length-1] = inventories[i];
            }
        }
        return refined;
    }
}

class Inventory{
    String inventoryId;
    int maximumQuantity;
    int currentQuantity;
    int threshold;
    public Inventory(String inventoryId, int maximumQuantity, int currentQuantity, int threshold){
        this.inventoryId = inventoryId;
        this.maximumQuantity = maximumQuantity;
        this.currentQuantity = currentQuantity;
        this.threshold = threshold;
    }
    public String getInventoryId(){
        return inventoryId;
    }
    public int getThreshold(){
        return threshold;
    }
}