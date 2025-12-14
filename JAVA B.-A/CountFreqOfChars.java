
import java.util.Scanner;

public class CountFreqOfChars {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the String : ");
        String s=sc.next();

        int[] freq=new int[256];// 256 Since it uses ASCII values for indexes
        for(char c:s.toLowerCase().toCharArray()){
            freq[c]++;
        }
        for(int i=0;i<256;i++){
            if(freq[i]>0){
                System.out.println((char)i+" "+freq[i]);
            }
        }
    }
}
