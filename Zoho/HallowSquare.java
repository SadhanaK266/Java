import java.util.*;
public class HallowSquare {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n%4==0){
            int RandCcount=(n/4)+1;
            int num1=1;
            // int num2=n;
            int lastrow=n-((n/4)-1);
            for(int i=0;i<RandCcount;i++){
                for(int j=0;j<RandCcount;j++){
                    if(i==0){
                        System.out.print((num1++)+" ");
                    }
                    else if(i==RandCcount-1){
                        System.out.print(lastrow+" ");
                        lastrow--;
                    }
                    else{
                        if(j==0){
                            System.out.print((n--)+" ");
                        }
                        if(j==RandCcount-1){
                            System.out.print((num1++)+" ");
                        }
                        else{
                            System.out.print(" ");
                        }
                    }
                }
                System.out.println();
            }
        }
        else{
            System.out.print("Kindly enter the mutiples of 4 as input");
        }
    }
}
