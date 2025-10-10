import java.util.Scanner;

public class PalindromeString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the String : ");
        String str=sc.nextLine().toLowerCase();
        //Using reverse String-------------------------------------------------->
        StringBuilder sb=new StringBuilder(str);
        String reverseString=sb.reverse().toString();
        if(str.equals(reverseString)){
            System.out.print(true);
        }
        else{
            System.out.print(false);
        }

        //Using 2 pointers--------------------------------------------------->
        // boolean isPalindrome=true;
        // int left=0,right=str.length()-1;
        // while(left<right){
        //     if(str.charAt(left)!=str.charAt(right)){
        //         isPalindrome=false;
        //     }
        //     left++;
        //     right--;
        // }
        // System.out.print(isPalindrome);

    }
}
