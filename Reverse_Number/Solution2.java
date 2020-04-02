import java.util.Scanner;
public class Solution{
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        StringBuffer str=new StringBuffer();
        str=str.append(number);
        System.out.print("The Reverse of the number is "+ str.reverse());
	}
}
