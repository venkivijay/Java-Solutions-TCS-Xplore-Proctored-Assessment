import java.util.Scanner;
class Solution{
    public static void main(String args[]){
        Scanner str=new Scanner(System.in);
        String word=str.nextLine();
        str.close();
        String []vowels={"a","e","i","o","u"};
        for(int i=0;i<vowels.length;i++){
            if(word.contains(vowels[i])){
                System.out.println(vowels[i]);
                break;

            }
        }        
    }
}
