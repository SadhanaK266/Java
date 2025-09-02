import java.util.Scanner;

public class Container{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value for n : ");
        int n=sc.nextInt();
        int arr[][]=new int[n][n];
        System.out.print("\n1.Add\n2.Remove\n3.Swap\n4.Move\n5.View\n6.Exit");
        
        while(true){
            System.out.print("\nEnter the choice : ");
            int Choice=sc.nextInt();
            if(Choice==1){
                System.out.println("Enter the position to be inserted");
                System.out.print("Row = ");
                int row=sc.nextInt();
                System.out.print("Coloumn = ");
                int column=sc.nextInt();
                if(row<=n && column<=n){
                    System.out.print("Enter the container weight : ");
                    int weight=sc.nextInt();
                    if(arr[row-1][column-1]==0){
                        arr[row-1][column-1]=weight;
                    }
                    else{
                        System.out.println("Position is already occupied");
                    }
                }
                else{
                    System.out.println("Invalid Input. Kindly enter the value between "+n);
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}