// Question 2: Remove Duplicates from Sorted Array
//Input:  [1, 1, 2, 2, 3]
//Output: [1, 2, 3, _, _]
//Length: 3
import java.util.*;

public class RemDupFromSortedArr {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value for n : ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter the array elements : ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int i=0;
        for(int j=1;j<n;j++){
            if(arr[j]!=arr[i]){
                i++;
                arr[i]=arr[j];
            }
        }
        System.out.println("The new Length is "+(i+1));
        System.out.print("Final Array is: ");
        for (int k = 0; k <= i; k++) {
            System.out.print(arr[k] + " ");
        }
    }
}
