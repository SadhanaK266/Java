import java.util.*;
public class Factorial{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        //without using built-in functions
        System.out.print("Enter the String : ");
        String str=sc.nextLine();
        int left=0;
        int right=str.length()-1;
        for(int i=0;i<str.length();i++){
            if(str.charAt(left)!=str.charAt(right)){

            }
        }



        // System.out.print("Enter the string : ");
        // String str=sc.nextLine();
        // // String normalized=str.toLowerCase();
        // // or For a line
        // String normalized = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        // System.out.println(normalized);
        // String sb=new StringBuilder(normalized).reverse().toString();
        // System.out.println(sb);
        
        // if(normalized.equals(sb)){
        //     System.out.println("Palindrome");
        // }
        // else{
        //     System.out.println("Not a palindrome");
        // }
    }
    //     System.out.print("Enter a number : ");
    //     int n=sc.nextInt();
    //     System.out.println(factorial(n));

    // }
    // public static int factorial(int n){
    //     if(n==0) return 0;
    //     if(n==1) return 1;
        
    //     return n*factorial(n-1);
    // }
}