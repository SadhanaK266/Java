import java.util.Scanner;

public class Prg11 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value for x : ");
        int x=sc.nextInt();
        System.out.print("Enter the value for y : ");
        int y=sc.nextInt();

        int a=x,b=y, temp,hcf,lcm;
        while(b!=0){
            temp=b;
            b=a%b;
            a=temp;
        }
        hcf=a;
        lcm=(x*y)/hcf;

        System.out.print("The LCM and HCF of "+x+" and "+y+" is : \nHCF : "+hcf+"\nLCM : "+lcm);
    }
}
