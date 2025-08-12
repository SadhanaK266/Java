
import java.util.Scanner;

public class Pattern2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        //top
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                System.out.print(n-j);
            }
            for(int k=0;k<(n*2)-(i*2)-1;k++){
                System.out.print(n-i);
            }
            for(int j=i;j>0;j--){
                System.out.print((n-j)+1);
            }
            System.out.println();
        }
        //bottom
         for(int i=n-2;i>=0;i--){
            for(int j=0;j<i;j++){
                System.out.print(n-j);
            }
            for(int k=0;k<(n*2)-(i*2)-1;k++){
                System.out.print(n-i);
            }
            for(int j=i;j>0;j--){
                System.out.print((n-j)+1);
            }
            System.out.println();
        }
    }
}
