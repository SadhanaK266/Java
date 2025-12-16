// Remove Duplicates from an array
import java.util.Scanner;
public class Prg8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int count=0;
        int res[]=new int[count];
        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                if(arr[i]==arr[j]){
                    continue;
                }
                count++;
            }
        }
        System.out.println(count);
    }
}
