//A merchant with cloth (curtian)
import java.util.Scanner;
public class Prg2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value for n : ");
        int n=sc.nextInt();
        System.out.print("Enter the "+n+" array elements : ");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("Enter the length of the curatin that the merchant have : ");
        int len=sc.nextInt();
        int res=0;
        
        for(int i=0;i<n;i++){
            if(arr[i]>=len){
                res+=arr[i]/len;
            }
        }
        System.out.print(res);
    }
}
