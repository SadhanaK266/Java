import java.util.Scanner;

public class Rectangle {
    private double length;
    private double breadth;

    public Rectangle(){
        this.length=1;
        this.breadth=1;
    }

    //for initializing the value
    public Rectangle(double length,double breadth){
        this.length=length;
        this.breadth=breadth;
    }
    //getters
    public double getLength(){
        return length;
    }
    public double  getBreadth(){
        return  breadth;
    }

    //setters
    public void setLength(double length){
        if(length>0){
            this.length=length;
        }
        else{
            System.out.println("Length must be positive.");
        }
    }

    public void setBreadth(double breadth){
        if(breadth>0){
            this.breadth=breadth;
        }
        else{
            System.out.println("Breadth must be positive.");
        }
    }

    public double calcArea(){
        return length*breadth;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the length : ");
        int len=sc.nextInt();
        System.err.print("Enter the breadth : ");
        int bre=sc.nextInt();
        Rectangle obj=new Rectangle();
        obj.setLength(len);
        obj.setBreadth(bre);

        double res=obj.calcArea();
        System.out.println("The area of the rectangle is : "+res);
    }
}
