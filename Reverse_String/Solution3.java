import java.util.Scanner;
public class Solution3{
public static void main(String[] args[]){
  Scanner sc = new Scanner(System.in);
  String str = sc.nextLine();
  System.out.println("Original String is Lower case:"+str.toLowerCase()+" and length is: "+str.length());
        for(int i=str.length()-1;i>=0;i--){
            System.out.print(str.toLowerCase().charAt(i));
        }  
  }
}
