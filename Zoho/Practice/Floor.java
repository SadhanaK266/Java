import java.util.Scanner;

public class Floor {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int ResSum=sc.nextInt();
        int freq[]=new int[n];
        
        for(int i=0;i<n;i++){
            freq[i]=ResSum/arr[i];
        }
        int temp1=ResSum/arr[0];
        int temp2=ResSum/arr[1];
        int temp3=ResSum/arr[2];
        for(int i=0;i<=temp1;i++){
            for(int j=0;j<=temp2;j++){
                for(int k=0;k<=temp3;k++){
                    int sum=i*arr[0] + j*arr[1] + k*arr[2];
                    if(sum==ResSum){
                        freq[0]=i;
                        freq[1]=j;
                        freq[2]=k;
                    }
                }
            }
        }
        System.out.println("In-order to get the target element we need to combine ");
        for(int i=0;i<n;i++){
            System.out.println(arr[i]+ " - " +freq[i]+" times");
        }
    }
}
