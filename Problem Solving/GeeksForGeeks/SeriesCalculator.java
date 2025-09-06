import java.util.Scanner;

public class SeriesCalculator {
    public int calcSum(int n){
        int a=1;//a is the first term
        int d=2;// d is the common difference of the series(1+3+5+...)

        return  n*(2*a + (n-1) *d)/2;//formula Sum = (n/2) * [2*a + (n-1)*d]
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the count of the series :  ");
        int n=sc.nextInt();
        SeriesCalculator obj=new SeriesCalculator();
        int res=obj.calcSum(n);
        System.out.println("The sum of "+n+" series is "+res);

    }
}
