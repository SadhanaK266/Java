// Prg to find the difference btw elements at odd index and even index.
import java.util.*;
public class Prg1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value for n : ");
        int n=sc.nextInt();
        System.out.print("Enter the "+n+" array elements : ");
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int oddSum=0;
        int evenSum=0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                evenSum+=arr[i];
            }
            else{
                oddSum+=arr[i];
            }
        }
        System.out.print(Math.abs(oddSum-evenSum));
    }
}