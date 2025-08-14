
import java.util.Scanner;

public class Pattern4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a value : ");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            for(int space=n-1;space>i;space--){
                System.out.print("-");
            }
            int num=1;
            for(int j=i;j<(i*2)+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
