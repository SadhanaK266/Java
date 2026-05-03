//Question 1: Find Second Largest Element in Array

import java.util.Scanner;
import javax.sound.midi.SysexMessage;

public class SecondLargestEle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value for n : ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.print("Enter the array elements : ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int first=Integer.MIN_VALUE;
        int second=Integer.MIN_VALUE;

        for(int nums:arr){
            if(nums> first){
                second=first;
                first=nums;
            }
            else if(nums>second && nums!=first){
                second=nums;
            }
        }
        System.out.println("The second Largest element is "+second);
    }
}
