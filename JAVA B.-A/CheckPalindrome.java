import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n=sc.nextInt();
        int rev=0;
        int temp=n;
        while(n>0){
            rev=(rev*10)+(n%10);
            n=n/10;
        }
        if(temp==rev){
            System.out.println("This number is a palindrome");
        }
        else{
            System.out.println("Not a palindrome");
        }

        System.out.print("Enter the String to check if it is Palindrome or not : ");
        String str=sc.next();
        String revStr="";
        //in built method
        // String revStr = new StringBuilder(str).reverse().toString();
        for(int i=str.length()-1;i>=0;i--){
            revStr+=str.charAt(i);
        }
        if(str.equalsIgnoreCase(revStr)){
            System.out.print("The given String is Plaindrome");
        } 
        else{
            System.out.print("The given String is not a Palindrome ");
        }     
    }
}
