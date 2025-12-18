// MAtrix addition
import java.util.Scanner;
public class Matrix1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of rows : ");
        int r=sc.nextInt();
        System.out.print("Enter the number of columns : ");
        int c=sc.nextInt();

        int a[][]=new int[r][c];
        int[][] b=new int[r][c];
        int sum[][]=new int[r][c];

        System.out.print("Enter the value of first matix : ");
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                a[i][j]=sc.nextInt();
            }
        }
        System.out.print("Enter the value of second matix : ");
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                b[i][j]=sc.nextInt();
            }
        }

        if(a.length==b.length && a[0].length==b[0].length){
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    sum[i][j]=a[i][j]+b[i][j];
                }
            }

            System.out.println("The addition of the given matrices : ");
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    System.out.print(sum[i][j]+" ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("These matrices can't be added ");
        }
    }
}