
import java.util.Scanner;

public class ExcelCol {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int res=0;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            res=res*26 +(ch-'A'+1);
        }
        System.out.println(res);
        sc.close();
    }
}
