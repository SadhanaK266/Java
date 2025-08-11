import java.util.*;

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number");
        int num=sc.nextInt();
        StringBuilder res=new StringBuilder();
        while(num>0){
            int digit=num%2;
            res.append(digit);
            num=num/2;
        }
        System.out.print(res.reverse());

    }
}
