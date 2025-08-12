import java.util.Scanner;

public class Problem9 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value for n : ");
        int n=sc.nextInt();
        int arr[]=new int[(n*2)+1];
        arr[0]=0;arr[1]=1;
        int sum=0;

        for(int i=2;i<=n*2;i++){
            arr[i]=arr[i-1]+arr[i-2];
            if(i%2==0){
                sum=sum+arr[i];
            }
        }
        // for(int i=0;i<arr.length;i++){
        //     System.out.print(arr[i]+" ");
        // }
        System.out.print("The sum of numbers at even indexes = "+sum);
    }
}
