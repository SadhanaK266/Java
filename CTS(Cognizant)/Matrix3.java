// check the matrix is diagonal or not
import java.util.Scanner;

public class Matrix3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value for row : ");
        int r=sc.nextInt();
        System.out.print("Enter the value for column : ");
        int c=sc.nextInt();

        if(r!=c){
            System.out.println("Enter the same value for row and column");            
        }
        
        else{
            int a[][]=new int[r][c];
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    a[i][j]=sc.nextInt();
                }
            }
            
            boolean res=true;
        
            // left to right diagonal
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    if(i==j){
                        if(a[i][j]==0){
                            res=false;
                            break;
                        }
                    }
                    else if(a[i][j]!=0){
                        res=false;
                        break;
                    }
                }
            }
            if(res){
                System.out.println("Diagonal");
            }
            else{
                System.out.println("Not a diagonal");
            }
        } 
    }
}
