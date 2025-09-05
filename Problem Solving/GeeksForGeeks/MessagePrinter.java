
import java.util.Scanner;

class MessagePrinter{
    public void printMessage(String name){
        System.out.print("Hello "+name);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the name : ");
        String name=sc.nextLine();
        MessagePrinter obj=new MessagePrinter();
        obj.printMessage(name);
    }
}