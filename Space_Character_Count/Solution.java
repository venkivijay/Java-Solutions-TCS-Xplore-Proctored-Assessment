import java.util.Scanner;
class Solution{
    public static void main(String[] args){
        int space_count=0,char_count=0;
        Scanner s=new Scanner(System.in);
        String input=s.nextLine();
        s.close();
        char[] result = input.toCharArray();
        for(int i=0;i<result.length;i++){
            if(Character.isWhitespace(result[i])){
                space_count++;
            }
            else if(!Character.isDigit(result[i])){
                char_count++;
            }
        }
        System.out.println("No of spaces : " +space_count +" and characters : " +char_count);
    }
}