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
        int res[]=new int[n];
        for(int i=0;i<n;i++){
            boolean isDuplicate=false;
            for(int j=0;j<count;j++){
                if(arr[i]==res[j]){
                    isDuplicate=true;
                    break;
                }
            }
            if(!isDuplicate){
                res[count]=arr[i];
                count++;
            }
        }
        System.out.println("After removing the duplicates : ");
        for(int i=0;i<count;i++){
            System.out.print(res[i]+" ");
        }
    }
}
