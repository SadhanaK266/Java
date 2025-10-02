import java.util.*;
public class MergeRows {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i][0]>arr[j][0]){
                    int[] temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }

        ArrayList<int[]> list=new ArrayList<>();
        int[] current=arr[0];
        for(int i=1;i<n;i++){
            int[] next=arr[i];
            if(current[1]>=next[0]){
                current[1]=Math.max(current[1],next[1]);
            }
            else{
                list.add(current);
                current=next;
            }
        }
        System.out.println("The Merged rows are as follows : ");
        list.add(current);
        for(int[] i:list){
            System.out.println(i[0]+" "+i[1]);
        }
    }
}
