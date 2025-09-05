
import java.util.*;

public class FirstNonReplacingEle {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Map<Integer,Integer> freq=new LinkedHashMap<>();
        for(int num:arr){
            freq.put(num,freq.getOrDefault(num, 0) + 1);
        }

        int ans = -1;
        for (int num : freq.keySet()) {
            if (freq.get(num) == 1) {
                ans = num;
                break;
            }
        }

        System.out.println(ans);
    }
}
