//Question 5: Two Sum (VERY IMPORTANT)
//Input:  arr = [2, 7, 11, 15], target = 9  
//Output: indices (0, 1)  → because 2 + 7 = 9

import java.util.*;
public class TwoSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("Enter the target element : ");
        int target=sc.nextInt();
        
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int temp=target-arr[i];
            if(map.containsKey(temp)){
                System.out.println("Indices : "+map.get(temp)+" "+i);
            }
            map.put(arr[i],i);
        }
    }
}


// 🧠 Approach 1: Brute Force
// 👉 Check every pair
// 💻 Code (Simple but slow)
// for (int i = 0; i < arr.length; i++) {
//     for (int j = i + 1; j < arr.length; j++) {
//         if (arr[i] + arr[j] == target) {
//             System.out.println(i + " " + j);
//         }
//     }
// }