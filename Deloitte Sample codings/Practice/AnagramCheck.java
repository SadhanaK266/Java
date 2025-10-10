import java.util.Scanner;
import java.util.Arrays;
public class AnagramCheck {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the first String : ");
        String str1=sc.nextLine().toLowerCase().replaceAll("\\s", "");
        System.out.print("Enter the second string : ");
        String str2=sc.nextLine().toLowerCase().replaceAll("\\s", "");

        //Using frequency count checking------------------------------------------->
        if(CheckStringsUsingFreq(str1, str2)){
            System.out.println("Anagram");
        }
        else{
            System.out.println("Not an anagram");
        }

    }
    static boolean CheckStringsUsingFreq(String s1,String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        int[] freq=new int[26];
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
            freq[s2.charAt(i)-'a']--;
        }
        for(int chFreq:freq){
            if(chFreq!=0){
                return false;
            }
        }
        return true;
    }


        // if(CheckStrings(str1,str2)){
        //     System.out.println("Anagram");
        // }
        // else{
        //     System.out.println("Not an anagram");
        // }


    // }
    // static boolean CheckStrings(String s1,String s2){
    //     if(s1.length()!=s2.length()){
    //         return false;
    //     }
    //     char[] cArr1=s1.toCharArray();
    //     char[] cArr2=s2.toCharArray();
        
    //     Arrays.sort(cArr1);
    //     Arrays.sort(cArr2);
        
    //     return Arrays.equals(cArr1,cArr2);
    // }
}
