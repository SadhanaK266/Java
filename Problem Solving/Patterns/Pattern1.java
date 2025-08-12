
import java.util.Scanner;

public class Pattern1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n/2;i++){
            //top 
            for(int j=0;j<n/2-i;j++){
                System.out.print("* ");
            }
            for(int k=0;k<i;k++){
                System.err.print("  ");
            }
            for(int k=0;k<i;k++){
                System.err.print("  ");
            }
            for(int j=n/2;j>i;j--){
                System.out.print("* ");
            }
            System.out.println();
        }
        //bottom
        for(int i=0;i<n/2;i++){
            //top 
            for(int j=0;j<=i;j++){
                System.out.print("* ");
            }
            for(int k=0;k<n/2-i-1;k++){
                System.err.print("  ");
            }
            for(int k=0;k<n/2-i-1;k++){
                System.err.print("  ");
            }
            for(int j=0;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
