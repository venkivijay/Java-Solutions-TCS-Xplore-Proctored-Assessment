import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static int primeCount;
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        input = input.replace(";", "");
        String[] inputArray = input.split(" ");
        int[] resultArray = new int[0];
        for(int i=0;i<inputArray.length;i++){
            boolean result = isPrimeNumber(Integer.parseInt(inputArray[i]));
            if(result == true){
                resultArray = Arrays.copyOf(resultArray, resultArray.length+1);
                resultArray[resultArray.length-1] = Integer.parseInt(inputArray[i]);
                primeCount++;
            }
        }
        Arrays.sort(resultArray);
        System.out.println(resultArray[resultArray.length-2]+primeCount);
    }
    
    
    public static boolean isPrimeNumber(int number){
        if(number<=1){
            return false;
        }
        for(int i=2;i<Math.sqrt(number);i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }
}