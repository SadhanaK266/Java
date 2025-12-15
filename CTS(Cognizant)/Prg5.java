// Check whether the number is palindrome or not
import java.util.Scanner;
public class Prg5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n=sc.nextInt();
        int rev=0;
        int original=n;
        while(n>0){
            rev=(rev*10)+(n%10);
            n/=10;
        }

        if(rev==original){
            System.out.print("Palindrome");
        }
        else{
            System.out.print("Not a palindrome");
        }
    }
}
