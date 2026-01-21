// to check if it is an empty/ null matrix
import java.util.*;
public class Matrix2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value for row : ");
        int r=sc.nextInt();
        System.out.print("Enter the value for column : ");
        int c=sc.nextInt();

        boolean res=true;
        int a[][]=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                a[i][j]=sc.nextInt();
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(a[i][j]!=0){
                    res=false;
                    break;
                }
            }
        }
        if(res){
            System.out.println("The given matrix is a null matrix");
        }
        else{
            System.out.println("The matrix is not a null matrix");
        }
    }
}
