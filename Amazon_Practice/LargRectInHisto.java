import java.util.*;
public class LargRectInHisto {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value for n : ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter the "+n+" Elements :");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        // for(int i=0;i<n;i++){
        //     for(int j=i;j<n;j++){
        //         int min=Integer.MAX_VALUE;
        //          for(int k=i;k<=j;k++){
        //             if(arr[k]<min){
        //                 min=arr[k];
        //             }
        //          }
        //          int size=j-i+1;
        //          int area=min*size;
        //          max=Math.max(max,area);
        //     }
        // }
        // System.out.println("Area:"+max);

        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                    int min=Integer.MAX_VALUE;
                    for(int k=i;k<=j;k++){
                        if(arr[k]<min){
                            min=arr[k];
                        }
                    }
                    max=Math.max(max,(min*((j-i)+1)));
            }
        }
        System.out.print(max);
    }

}
