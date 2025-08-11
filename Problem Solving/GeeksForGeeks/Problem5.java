import java.util.*;
public class Problem5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number : ");
        int num=sc.nextInt();
        int res=1;
        while(num>0){
            res=res*num;
            num=num-1;
        }
        System.out.println(res);
    }
}
