import java.util.*;
public class SubArrSum{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("n = ");
        int n=sc.nextInt();
        System.out.print("Target = ");
        int target=sc.nextInt();
        System.out.print("arr = ");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
    

        boolean result=hasSubArrWithTargetAsSum(arr, n, target);
        System.out.println(result);
    }
    public static boolean hasSubArrWithTargetAsSum(int arr[],int n,int target){
        int start=0,currSum=0;
        for(int end=0;end<n;end++){
            currSum+=arr[end];
            while(currSum>target && start<=end){
                currSum-=arr[start];
                start++;
            }
            if(currSum==target){
                return true;
            }
        }
        return false;
    }
}
// import java.util.Scanner;

// public class SubArrSum {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.print("n = ");
//         int n=sc.nextInt();
//         System.out.print("Sum : ");
//         int sum=sc.nextInt();
//         System.out.print("arr = ");
//         int arr[]=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
        
//         boolean found=false;
//         for(int i=0;i<n-2;i++){
//             for(int j=i+1;j<n-1;j++){
//                 for(int k=j+1;k<n;k++){
//                     if((arr[i]+arr[j]+arr[k])==sum){
//                         found=true;
//                     }
//                 }
//             }
//         }
//         if(!found){
//             System.out.println("No subArray found ");
//         }
        
//         else{
//             System.out.print(found);
//         }
//     }
// }
