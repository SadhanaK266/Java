import java.util.*;
public class ArmstrongNum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number : ");
        int num=sc.nextInt();
        int og=num;

        int temp=num;
        int digits=0;
        while(temp>0){
            digits++;
            temp=temp/10;
        }

        int sum=0;
        int t=num;
        while(t>0){
            int d=t%10;
            sum+=Math.pow(d,digits);
            t=t/10;
        }

        if(sum==og){
            System.out.println(og+" is an Armstrong number ");
        }
        else{
            System.out.println(og+" is not an Armstrong number");
        }
    }
}
