import java.util.Scanner;

public class StrDupRem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the String : ");
        String s=sc.nextLine();
        String res="";
        String str=s.replaceAll("\\s", "");
        for(int i=0;i<str.length();i++){
            if(res.indexOf(str.toLowerCase().charAt(i))==-1){
                res+=str.charAt(i);
            }
        }
        System.out.print("The String after Removing Duplicates : "+res);
    }
}
