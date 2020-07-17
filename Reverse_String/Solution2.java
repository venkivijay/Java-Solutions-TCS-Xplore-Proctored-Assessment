import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        input = input.toLowerCase();
        char[] inputArray = input.toCharArray();
        for (int i = inputArray.length - 1; i >= 0; i--) {
            System.out.print(inputArray[i]);
        }

    }
}