import java.util.*;
public class Problem8{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a value for n : ");
        int n=sc.nextInt();

        for(int i=0;i<=n;i++){
            for(int space=0;space<=n-i-1;space++){
                System.out.print("  ");// 2 space
            }
            int num=1; //always the 1st row is 1
            for(int j=0;j<=i;j++){
                System.out.printf("%4d",num);
                num=num*(i-j)/(j+1);
            }
            System.out.println();
        }
    }
}