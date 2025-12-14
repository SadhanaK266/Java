import java.util.Scanner;
public class SwapTwoNumWOAnother {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println("Before Swapping : "+a+" "+b);
        a=a+b;
        b=a-b;
        a=a-b;
        System.out.print("After Swapping : "+a+" "+b);
    }
}
