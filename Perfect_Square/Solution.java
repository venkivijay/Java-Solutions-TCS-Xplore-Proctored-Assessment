import java.util.Scanner;
class Solution{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int number = s.nextInt();
        s.close();
        double result = Math.sqrt(number);
        if((int) result == result){
            System.out.println("TRUE");
        }
        else System.out.println("FALSE");

    }
}
