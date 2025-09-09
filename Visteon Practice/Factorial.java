import java.util.*;
public class Factorial{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n=sc.nextInt();
        System.out.println(factorial(n));

    }
    public static int factorial(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        
        return n*factorial(n-1);
    }
}