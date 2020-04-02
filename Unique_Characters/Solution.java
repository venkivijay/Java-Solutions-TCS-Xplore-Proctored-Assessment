import java.util.Scanner;

public class Solution {
    public static void main(String[] args)
    {
         Scanner sc = new Scanner(System.in);
         String input = sc.nextLine();
         sc.close();
         input = input.toLowerCase();
         String temp = "";
         for(int i =0;i<input.length();i++){
             if(!temp.contains(Character.toString(input.charAt(i)))){
                 temp = temp+input.charAt(i);
             }
         }
         System.out.println(temp);
    }
}