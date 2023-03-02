import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        s.close();
        input = input.toLowerCase();
        int vowelCount = 0, consonantCount = 0;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i) >= 'a' && input.charAt(i) <= 'z'){
                switch(input.charAt(i)) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        ++vowelCount;
                    default:
                        ++consonantCount;
                }
            }
        }
        System.out.println("Vowels count - "+vowelCount);
        System.out.println("Consonant Count - "+consonantCount);
    }
}
