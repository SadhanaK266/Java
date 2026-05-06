import java.util.Scanner;

public class Reverse_A_String {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int left=0;
        int right=str.length()-1;

        char[] chArr=str.toCharArray();
        while(left<right){
            char temp=chArr[left];
            chArr[left]=chArr[right];
            chArr[right]=temp;

            left++;
            right--;
        }
        String reversed=new String(chArr);
        System.out.println(reversed);
    }
}
