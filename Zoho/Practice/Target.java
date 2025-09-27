import java.util.*;
public class Target{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the n value of array 1 : ");
        int n1=sc.nextInt();
        int arr1[]=new int[n1];
        System.out.println("Enter the "+n1+" elements of array 1 :");
        for(int i=0;i<n1;i++){
            arr1[i]=sc.nextInt();
        }

        System.out.print("Enter the n value for the array 2: ");
        int n2=sc.nextInt();
        int[] arr2=new int[n2];
        System.out.println("Enter the "+n2+" elements of array2 : ");
        for(int j=0;j<n2;j++){
            arr2[j]=sc.nextInt();
        }
        System.out.print("Enter the target element :");
        int target=sc.nextInt();
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(arr1[i]+arr2[j]==target){
                    System.err.println(arr1[i]+" + "+arr2[j]+" = "+target);
                }
            }
            
        }
    }
}