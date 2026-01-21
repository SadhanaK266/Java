import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the String : ");
        String str=sc.nextLine();
        str=str.toLowerCase();
        String rev="";

        for(int i=str.length()-1;i>=0;i--){
            rev=rev+str.charAt(i);
        }
        if(str.equals(rev)){
            System.out.println("Palindrome");
        }
        else{
            System.out.println("Not a Palindrome");
        }
    }
}
