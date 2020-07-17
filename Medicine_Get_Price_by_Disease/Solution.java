import java.util.Arrays;
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Medicine[] medicines = new Medicine[4];
        for(int i =0;i<medicines.length;i++) {
            medicines[i] = new Medicine(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextInt());
            sc.nextLine();
        }
        String disease = sc.nextLine();
        sc.close();
        Integer[] result = getPriceByDisease(medicines,disease);
        for(int i=0;i<result.length;i++) {
            System.out.println(result[i]);
        }
    }
    public static Integer[] getPriceByDisease(Medicine[] medicines,String disease) {
        Integer[] result = new Integer[0];
        for(int i=0;i<medicines.length;i++) {
            if(medicines[i].getDisease().equalsIgnoreCase(disease)) {
                result = Arrays.copyOf(result, result.length+1);
                result[result.length-1] = medicines[i].getPrice();
            }
            Arrays.sort(result);
        }
        return result;
    }
}
class Medicine{
    String MedicineName;
    String batch;
    String disease;
    int price;

    public String getDisease() {
        return disease;
    }
    public int getPrice() {
        return price;
    }

    public Medicine(String medicineName, String batch, String disease, int price) {
        this.MedicineName = medicineName;
        this.batch = batch;
        this.disease = disease;
        this.price = price;
    }
}