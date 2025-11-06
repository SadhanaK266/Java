import java.util.Arrays;
import java.util.Scanner;

public class KLargestEle{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value for n : ");
        int n=sc.nextInt();
        System.out.print("Enter the "+n+" array elements :");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("Enter the value for k :");
        int k=sc.nextInt();


        // Naive Approach -Using sorting
        Arrays.sort(arr);
        int temp=n-k;
        for(int i=n-1;i>=n-k;i--){
            System.out.print(arr[i]+" ");
        }
        //USing priority Queue (min heap)
        
    }
}