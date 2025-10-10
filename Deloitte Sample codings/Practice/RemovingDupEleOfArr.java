
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class RemovingDupEleOfArr {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("n = ");
        int n=sc.nextInt();
        System.out.print("arr = ");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print(Arrays.toString(AfterRemoval(arr)));
    }
    private static int[] AfterRemoval(int arr[]){
        HashSet<Integer> set =new HashSet<>();
        for(int i:arr){
            set.add(i);
        }
        int result[]=new int[set.size()];
        int i=0;
        for(int num:set){
            result[i]=num;
            i++;
        }
        return result;
    }
}
