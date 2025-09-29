import java.util.*;
public  class MinSwaps{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the count for the array elements : ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int[] b=new int[n];
        for(int i=0;i<n;i++){
            b[i]=arr[i];
        }
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(b[i]>b[j]){
                    int temp=b[i];
                    b[i]=b[j];
                    b[j]=temp;
                }
            }
        }

        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],i);
        }
        
        int count=0;
        for(int i=0;i<n;i++){
            int current=b[i];
            if(current!=arr[i]){
                count++;
                int currentIndex=map.get(current);
                map.put(arr[i],currentIndex);
                map.put(current,i);

                int temp=arr[i];
                arr[i]=arr[currentIndex];
                arr[currentIndex]=temp;
            }
        }
        
        
        System.out.println("The minimum swaps required to get the sorted array is : "+count);
    }
}