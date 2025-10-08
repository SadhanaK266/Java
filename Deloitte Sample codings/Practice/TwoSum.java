
import java.util.*;
public class TwoSum{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value for n :");
        int n=sc.nextInt();
        System.out.println("Enter the "+n+" array elements : ");
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("Enter the target value : ");
        int target=sc.nextInt();
        boolean found=false;

        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                if((arr[i]+arr[j])==target){
                    found=true;
                    System.out.println("Array element of "+i+" and "+j+" is "+target);
                }
            }
        }
        if(!found)
        {
            System.out.println("No possible outcome available ");
        }
    }
}