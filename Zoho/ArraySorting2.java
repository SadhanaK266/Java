import java.util.Scanner;

public class ArraySorting2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value for n : ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        //to find max and min
        for(int m=0;m<n;m++){
            if(arr[m]<min){
                min=arr[m];
            }
            if(arr[m]>max){
                max=arr[m];
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i]==arr[j]-1){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }
}
