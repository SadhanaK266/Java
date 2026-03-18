import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<String> tasks=new ArrayList<>();

        int choice;
        while (true){ 
            System.out.println("\n------- To-Do List Menu ------");
            System.out.println("1.Add Task\n2.View Tasks\n3.Remove Tasks\n4.Exit");
            System.out.println("Enter your choice : ");
            choice=sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the task description : ");
                    String taskDesc=sc.nextLine();
                    tasks.add(taskDesc);
                    System.out.println("Your Task added");
                    break;
                case 2:
                    if(tasks.isEmpty()){
                        System.out.println("No task available");
                    }
                    else{
                        for(int i=0;i<tasks.size();i++){
                            System.out.println((i+1)+". "+tasks.get(i));
                        }
                    }
                    break;
                case 3:
                    System.out.print("The tasks available are \n ");
                    for(int i=0;i<tasks.size();i++){
                        System.out.println((i+1)+". "+tasks.get(i));
                    }
                    System.out.print("Enter the task that you wanted to remove : ");
                    int taskToBeRemoved=sc.nextInt();
                    sc.nextLine();
                    if(taskToBeRemoved>0 && taskToBeRemoved<=4){
                        tasks.remove(taskToBeRemoved-1);
                        System.out.println("Task removed");
                    }
                    break;
                case 4:
                    System.out.println("Exited...");
                    System.exit(0);
                default:
                    System.out.println("Kindly enter the valid number");
            }
        }
    }
}
