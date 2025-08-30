import java.util.*;
public class digCount {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value for n : ");
        int n=sc.nextInt();
        int arr[][]=new int[n][n];
        int sum=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
                if(i==j){
                    sum+=arr[i][j];
                }
            }
        }
        System.out.println("The  sum is "+sum);
    } 
}
