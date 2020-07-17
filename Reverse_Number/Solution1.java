import java.util.Scanner;
public class Solution1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int digit = sc.nextInt();
        sc.close();
        System.out.print("Reverse of the number is ");
        if(digit == 0)
            System.out.print(0);
        else {
            while(digit!=0){
                System.out.print(digit%10);
                digit /= 10;
            }
        }
    }
}
