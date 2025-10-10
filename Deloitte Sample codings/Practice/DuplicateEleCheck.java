import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class DuplicateEleCheck {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("n = ");
        int n=sc.nextInt();
        System.out.print("arr = ");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        boolean result=hasDuplicateElementOrNot(arr);
        System.out.println(result);
    }
    static boolean hasDuplicateElementOrNot(int[] arr){
        HashSet<Integer> set=new HashSet<>();
        for(int i:arr){
            if(set.contains(i)){
                return true;
            }
            set.add(i);
        }
        return  false;
    }
        //Using HashSet--- Efficient-O(n)------------------------>
            //A HashSet is a collection in Java that:
            // Stores unique elements only (no duplicates allowed).
        

        // boolean present=false;
        // for(int i=0;i<n-1;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(arr[i]==arr[j]){
        //             present=true;
        //         }
        //     }
        // }
        // System.out.println(present);

        // can Be done using 1 for loop------------------>

        // Arrays.sort(arr);
        // boolean found = false;
        
        // for (int i = 1; i < n; i++) {
        //     if (arr[i] == arr[i-1]) {
        //         found = true;
        //         break;
        //     }
        // }
    // }
}
