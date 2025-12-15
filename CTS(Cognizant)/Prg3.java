//Total number of odd numbers between 1-100
import java.util.Scanner;
public class Prg3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the starting number : ");
        int startingNum=sc.nextInt();
        System.out.print("Enter the ending number : ");
        int endingNum=sc.nextInt();

        int count=0;
        for(int i=startingNum+1;i<endingNum;i++){
            if(i%2!=0){
                count++;
            }
        }
        System.out.print("The odd number(s) between "+startingNum+" and "+endingNum+" is : "+count);
    }
}
