import java.util.Scanner;

public class Array1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the length of an array : ");
        int num=sc.nextInt();
        int arr[]=new int[num];
        System.out.print("Enter the "+num+" array elements : ");
        for(int i=0;i<num;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("Enter the k value : ");
        int k=sc.nextInt();
        
        //-- works but doesn't give the change of order for all the array input
        for(int i=0;i<arr.length;i+=k){
            int left=i;
            int right=Math.min((i+k)-1 , arr.length-1);

            while(left< right){
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;

                left++;
                right--;
            }
        }
        for(int i=0;i<num;i++){
            System.out.print(arr[i]+" ");
        }
    }
}