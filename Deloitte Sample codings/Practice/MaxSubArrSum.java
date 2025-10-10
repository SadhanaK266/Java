
import java.util.Scanner;

public class MaxSubArrSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("n = ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int maxSumResult=kadane(arr);
        System.out.println("The Maximum Sum any subArray is "+maxSumResult);
    }
    public static int kadane(int arr[]){
        int currSum=arr[0],maxSum=arr[0];
        for(int i=1;i<arr.length;i++){
            currSum=Math.max(arr[i],(currSum+arr[i]));
            maxSum=Math.max(maxSum,currSum);
        }
        return maxSum;
    }
}
