import java.util.Scanner;

public class Prg4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Decimal value : ");
        int num=sc.nextInt();
        int binaryArr[]=new int[100];
        int idx=0;
        while(num>0){
            binaryArr[idx]=num%2;
            num=num/2;
            idx++;
        }
        System.out.print("The Binary value for "+num+" is : ");
        for(int i=idx-1;i>=0;i--){
            System.out.print(binaryArr[i]);
        }
    }
}
