import java.util.*;
public class Prg3 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();

        System.out.println("Before Swapping : "+a+" "+b);
        // int temp=a;
        // a=b;
        // b=temp;
        // System.out.print("After Swapping :"+a+" "+b);
        

        //Using BitWise XOR----------------->
        // a=a^b;
        // b=a^b;
        // a=a^b;
        // System.out.print("After Swapping :"+a+" "+b);


       // Using Arithmetic (Sum and Difference)------------------------->
       a=a+b;
       b=a-b;
       a=a-b;
       System.out.print("After Swapping :"+a+" "+b);
    }    
}
