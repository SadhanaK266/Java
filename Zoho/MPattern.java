import java.util.*;
public class MPattern{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a value : ");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j==0 ||j==n-1 ||((i==j||j==n-1-i)&&i<=(n/2))){
                    System.out.print("* ");
                }
                else{
                    System.err.print("  ");
                }
            }
            System.out.println();
        }
    }
}