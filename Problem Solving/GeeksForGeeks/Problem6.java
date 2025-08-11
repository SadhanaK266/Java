
import java.util.*;
public class Problem6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the first complex number : ");
        String a=sc.nextLine();
        System.out.print("Enter the second complex number : ");
        String  b=sc.nextLine();
        
        String[] aStrArr=a.replace("i", "").split("\\+");
        String[] bStrArr=b.replace("i", "").split("\\+");
        
        int aReal=Integer.parseInt(aStrArr[0]);
        int aImg=Integer.parseInt(aStrArr[1]);
        int bReal=Integer.parseInt(bStrArr[0]);
        int bImg=Integer.parseInt(bStrArr[1]);

        int sumReal=aReal+bReal;
        int sumImg=aImg+bImg;

        System.out.println("The sum of 2 complex number is : "+sumReal+"+"+sumImg+"i");
    }
}
