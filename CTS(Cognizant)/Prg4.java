//Fiding the Armstrong number between 1 - 1000
import java.util.Scanner;
public class Prg4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Starting number : ");
        int startingNum=sc.nextInt();
        System.out.print("Enter the Ending Number : ");
        int endingNum=sc.nextInt();
        
        for(int i=startingNum;i<=endingNum;i++){
            int original=i;
            int sum=0;
            while(original>0){
                int rem=original%10;
                sum+=rem*rem*rem;
                original/=10;
            }
            if(sum==i){
                System.out.println(i);
            }
        }
    }
}
