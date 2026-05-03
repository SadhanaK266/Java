//Question 4: Find Missing Number (1 to n)

//Missing = expected - actual
//int expectedSum = n * (n + 1) / 2;
//int actualSum = 0;

import java.util.Scanner;

public class FindMissingNumber1ton {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value of n : ");
        int n=sc.nextInt();
        int[] arr=new int[n-1];
        int actualSum=0;
        for(int i=0;i<n-1;i++){
            arr[i]=sc.nextInt();
            actualSum+=arr[i];
        }
        int expectedSum=n*(n+1)/2;
        int Missing=expectedSum-actualSum;
        System.out.println("The missing number is "+Missing);
    }
}
