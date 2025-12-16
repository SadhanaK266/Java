// Find the least number in the array
import java.util.Scanner;
public class Prg7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value for n : ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.print("Enter the array elements : ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int  min=arr[0];
        int idx=0;
        for(int i=1;i<n;i++){
            if(arr[i]<min){
                min=arr[i];
                idx=i;
            }
        }
        System.out.println("The smallest element in the array is : "+min);
        System.out.print("The index of the smallest element is : "+idx);

    }
}
