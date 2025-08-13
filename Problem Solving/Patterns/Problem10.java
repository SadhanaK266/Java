import java.util.Scanner;

public class Problem10 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of rows : ");
        int rows=sc.nextInt();
        for(int i=0;i<rows;i++){
            for(int space=0;space<rows-i-1;space++){
                System.out.print(" ");
            }
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            for(int k=0;k<i;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
