import java.util.Scanner;

public class Employee {
    private String name;
    private  int id;
    private  String dept;

    public Employee(String name){
        this.name=name;
    }
    public Employee(String name,int id){
        this.name=name;
        this.id=id;
    }
    public Employee(String name,int id,String dept){
        this.name=name;
        this.id=id;
        this.dept=dept;
    }

    public void displayDetails(){
        System.out.println("Name : "+name );
        if(id!=0){
            System.out.println("ID : "+id);
        }
        if(dept!=null){
            System.out.println("Department : "+dept);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the name : ");
        String name=sc.nextLine();
        System.out.print("Enter the id : ");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the Department : ");
        String department =sc.nextLine();

        Employee e1=new Employee(name);
        Employee e2=new Employee(name,id);
        Employee e3=new Employee(name, id, department);
        
        e1.displayDetails();
        System.out.println();
        e2.displayDetails();
        System.out.println();
        e3.displayDetails();
    }
}
