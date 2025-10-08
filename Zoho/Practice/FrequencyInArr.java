
import java.util.Scanner;

public class FrequencyInArr {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value for n : ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        boolean visited[]=new boolean[n];
        
        for(int i=0;i<n-1;i++){
            if(visited[i]){
                continue;
            }
            int temp=arr[i],count=1;
            for(int j=i+1;j<n;j++){
                if(arr[j]==temp){
                    visited[j]=true;
                    count++;
                }
            }
            System.out.println(temp+" = "+count);
        }
    }
}
