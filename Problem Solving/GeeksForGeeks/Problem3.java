
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println("Before swapping : a="+a+", b="+b);
        int temp=a;
        a=b;
        b=temp;
        System.out.println("After swapping : a="+a+", b="+b);
        
    }
}
