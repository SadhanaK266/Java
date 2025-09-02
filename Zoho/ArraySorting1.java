// import java.util.Scanner;

// public class ArraySorting1 {
//     public static void main(String args[]){
//         Scanner sc=new Scanner(System.in);
//         System.out.print("Enter a value for n :");
//         int n=sc.nextInt();
//         int arr[]=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         int count=0;
//         int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
//         //to find max and min
//         for(int m=0;m<n;m++){
//             if(arr[m]<min){
//                 min=arr[m];
//             }
//             if(arr[m]>max){
//                 max=arr[m];
//             }
//         }
//         for(int i=0;i<n;i++){
//             int temp=arr[i];
//             arr[i]=min;
//             min=temp;
//             // for(int j=i+1;j<n;j++){
//             //     if(arr[j]<arr[i]){
//             //         int temp=arr[j];
//             //         arr[j]=arr[i];
//             //         arr[i]=temp;
//             //         count++;
//             //     }
//             // }
//         }
//         System.out.print("The sorted array is ");
//         for(int i=0;i<n;i++){
//             System.out.print(arr[i]+" ");
//         }
//         System.out.println("\nThe Minimum swaps is "+count);
//     }
// }


import java.util.*;
public class ArraySorting1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a value for n : ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        int sortedArr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            sortedArr[i]=arr[i];
        }
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int temp=sortedArr[i];
                sortedArr[i]=sortedArr[j];
                sortedArr[j]=temp;
            }
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],i);
        }
        
        for(int i=0;i<n;i++){
            int corr=sortedArr[i];
            
        }

    }
}