import java.util.*;
public class Problem7 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the principal amount(P) : ");
        int p=sc.nextInt();
        System.out.println("Enter the time(T) : ");
        int t=sc.nextInt();
        System.out.println("Enter the rate(R) : ");
        int r=sc.nextInt();
    
        int simpleInterest=(p*t*r)/100;
        System.out.println(simpleInterest);
    }
}
