import java.util.Scanner;

public class LargestNum {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of elements : ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int firstDigit=afterDigCount(arr[i]);
                int secondDigit=afterDigCount(arr[j]);
                if((arr[i] *Math.pow(10,secondDigit)+arr[j]) < arr[j]*Math.pow(10,firstDigit)+arr[i]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i:arr){
            sb.append(String.valueOf(i));
        }
        System.out.println(sb);

    }
    public static int afterDigCount(int n){
        int temp=n;
        int count=0;
        while(temp>0){
            count++;
            temp/=10;
        }
        return count;
    }
}
