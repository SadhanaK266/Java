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
 // ---------- OR ---------------------------------------------------------

// public class MissingNumberXOR {

//     public static void main(String[] args) {
//         int[] arr = {1, 2, 4, 5};
//         int n = 5;

//         int xor1 = 0, xor2 = 0;

//         // XOR from 1 to n
//         for (int i = 1; i <= n; i++) {
//             xor1 ^= i;
//         }

//         // XOR of array
//         for (int num : arr) {
//             xor2 ^= num;
//         }

//         int missing = xor1 ^ xor2;

//         System.out.println("Missing number: " + missing);
//     }
// }
