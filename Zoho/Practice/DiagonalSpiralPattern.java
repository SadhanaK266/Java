import java.util.Scanner;

public  class  DiagonalSpiralPattern{
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter the value for n : ");
        int n=sc.nextInt();
        int temp=1;
        int arr[][]=new int[n][n];
        int top=0,bottom=n-1,left=0,right=n-1;
        while( top<=bottom && left<=right ){
            for(int j=left;j<=right;j++){
                arr[top][j]=temp++;
            }
            top++;
            int TBtemp=right;
            for(int i=top;i<=bottom;i++){
                arr[i][--TBtemp]=temp++;
            }
            right=right-2;
            bottom--;
            for(int i=bottom;i>=top;i--){
                arr[i][left]=temp++;
            }
            left++;
            bottom--;
        }
        // to display 
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==0){
                    System.out.print(" ");
                }
                else{
                    System.out.print(arr[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
}
// import java.util.Scanner;

// public class DiagonalSpiralPattern {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.print("Enter the number of rows: ");
//         int num=sc.nextInt();
//         int temp=1;
//         int arr[][]=new int[num][num];
//         for(int i=0;i<num;i++){
//             arr[0][i]=temp++;
//         }
//         int TBtemp=num-1;
//         for(int j=1;j<num;j++){
//             arr[j][--TBtemp]=temp++;
//         }
//         for(int k=num-2;k>0;k--){
//             arr[k][0]=temp++;
//         }
//         int LRtemp=1;
//         for(int l=1;l<num-3;l++){
//             arr[l][LRtemp]=temp++;
//         }
//         for(int i=0;i<num;i++){
//             for(int j=0;j<num;j++){
//                 System.out.print(arr[i][j]+" ");
//             }
//             System.out.println();
//         }
//     }
// }
