
import java.util.Scanner;

public class SubArrSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("n = ");
        int n=sc.nextInt();
        System.out.print("Sum : ");
        int sum=sc.nextInt();
        System.out.print("arr = ");
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        boolean found=false;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    if((arr[i]+arr[j]+arr[k])==sum){
                        found=true;
                    }
                }
            }
        }
        if(!found){
            System.out.println("No subArray found ");
        }
        
        else{
            System.out.print(found);
        }
    }
}
