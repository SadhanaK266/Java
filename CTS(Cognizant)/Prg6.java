// finding the largest element in the array
import java.util.Scanner;

public class Prg6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value for n : ");
        int n=sc.nextInt();
        System.out.print("Enter the "+n+ " array elements : ");
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int max=arr[0];
        int idx=0;
        for(int i=1;i<n;i++){
            if(arr[i]>max){
                max=arr[i];
                idx=i;
            }
        }

        System.out.println("The largest element in the array is : "+max);
        System.out.print("The index of the largest element is : "+idx);
    }
}
