
import java.util.Scanner;
public class Pattern1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<(i+i)+1;j++){
                System.out.print(i+1 +" ");
            }
            System.out.println();
        }
    }
}
