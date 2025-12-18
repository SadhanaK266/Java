//Program to print the odd and even numbers from an array
import java.util.*;
public class Prg9 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value for n : ");
        int n=sc.nextInt();
        System.out.print("Enter the "+n+" array elements :");
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("The odd Number(s) in the array :");
        for(int i=0;i<n;i++){
            if(arr[i]%2!=0){
                System.out.print(" "+arr[i]);
            }
        }
        System.out.println();
        System.out.print("The even Number(s) in the array : ");
        for(int i=0;i<n;i++){
            if(arr[i]%2==0){
                System.out.print(" "+arr[i]);
            }
        }
    }
}
