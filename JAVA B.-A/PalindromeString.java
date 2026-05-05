//Question 6: Check if a String is Palindrome

import java.util.Scanner;
public class PalindromeString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String lower=str.toLowerCase();
        boolean isPalindrome=true;
        int left=0;
        int right=str.length()-1;


        while(left<right){
            if(lower.charAt(left)!=lower.charAt(right)){
                isPalindrome=false;
            }
            left++;
            right--;
        }
        
        if(isPalindrome){
            System.out.println(str+" is Palindrome");
        }
        else{
            System.out.println(str+" is not a Palindrome");
        }
    }
}
