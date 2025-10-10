
import java.util.HashSet;
import java.util.Scanner;

public class LongestUniqueSubString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the String : ");
        String str=sc.nextLine();
        System.out.print(LengthOfLongestUniqueSubString(str));

    }
    public static int LengthOfLongestUniqueSubString(String s){
        int start=0;
        int maxLen=0;
        HashSet<Character> set=new HashSet<>();
        for(int end=0;end<s.length();end++){
            char ch=s.charAt(end);

            while(set.contains(ch)){
                set.remove(s.charAt(start));
                start++;
            }
            set.add(ch);
            maxLen=Math.max(maxLen,(end-start+1));
        }
        return maxLen;
    }
}
