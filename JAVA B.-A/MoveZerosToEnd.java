//Question 3: Move All Zeros to End (Maintain Order)
import java.util.Scanner;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value for n : ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter the array elements : ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int i=0;
        for(int nums:arr){
            if(nums!=0){
                arr[i]=nums;
                i++;
            }
        }
        while(i<arr.length){
            arr[i]=0;
            i++;
        }
        for(int nums:arr){
            System.out.print(nums+" ");
        }
    }
}
