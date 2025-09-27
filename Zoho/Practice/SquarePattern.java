
import java.util.Scanner;

public class SquarePattern {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num=sc.nextInt();
        if(num%4!=0){
            System.out.println("Kindly enter the number as  the multiples of 4");
        }
        else{
            int rowAndColCount=(num/4)+1;
            int temp=1;
            int lTemp=num;
            for(int i=1;i<=rowAndColCount;i++){
                for(int j=1;j<=rowAndColCount;j++){
                    if(i==1){
                        System.out.print(temp+" ");
                        temp++;
                    }
                    else if(i==rowAndColCount){
                        System.out.print(lTemp+" ");
                        lTemp--;
                    }
                    else{
                        if(j==1){
                            System.out.print(lTemp+" ");
                            lTemp--;
                        }
                        else if(j==rowAndColCount){
                            System.out.print(temp+" ");
                            temp++;
                        }
                        else{
                            System.out.print("  ");
                        }
                    }
                }
                System.out.println();
            }
        }
    }
}
