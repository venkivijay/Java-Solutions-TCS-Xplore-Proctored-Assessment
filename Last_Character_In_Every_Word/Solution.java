import java.util.Scanner;
class Solution{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String input=s.nextLine();
        s.close();
        char[] result = input.toCharArray();
        for(int i=0;i<result.length;i++){
            if(Character.isWhitespace(result[i]) && !Character.isDigit(result[i-1]) && !Character.isWhitespace(result[i-1])){
                System.out.print(result[i-1]);
            }
            else if(i == result.length-1 && !Character.isDigit(result[i])){
                System.out.print(result[i]);
            }
        }
    }
}
