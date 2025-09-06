
import java.util.Scanner;

public class Biggest {
    // private int[] arr;
    public void displayDetails(int arr[]){
        if(arr==null|| arr.length==0){
            System.out.println("The array is empty");
        }
        int l=arr[0];
        for(int n:arr){
            if(n>l){
                l=n;
            }
        }
        System.out.println("The largest element in the array is "+l);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value for n :  ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.print("Enter the array elements : ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Biggest obj=new Biggest();
        obj.displayDetails(arr);
    }
}
