import java.util.*;
public class CompLargestNum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        String[] s=new String[n];
        for(int i=0;i<n;i++){
            s[i]=String.valueOf(a[i]);
        }
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(Integer.parseInt(s[i]+s[j])<Integer.parseInt(s[j]+s[i])){
                    String temp=s[i];
                    s[i]=s[j];
                    s[j]=temp;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(String i:s){
            sb.append(i);
        }
        System.out.println(sb.toString());
    }
}
