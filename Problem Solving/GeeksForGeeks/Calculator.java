import java.util.Scanner;

class  Calculator{
    public int calculateSum(int number1,int number2){
        return number1+number2;
    }
    public int calculateDifference(int n1,int n2){
        return n1-n2;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value for number1 : ");
        int num1=sc.nextInt();
        System.out.print("Enter the value for number2 : ");
        int num2=sc.nextInt();

        Calculator obj =new Calculator();
        int sum=obj.calculateSum(num1, num2);
        int diff=obj.calculateDifference(num1, num2);
        System.out.println("Sum = "+sum);
        System.out.println("Difference = "+diff);
        
    }
}