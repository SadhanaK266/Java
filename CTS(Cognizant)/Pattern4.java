// Diamond Pattern 
import java.util.Scanner;
public class Pattern4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number :");
        int n=sc.nextInt();
        if(n%2==0){
            System.out.print("Kindly enter only the odd numbers");
        }
        
        else{
            //upper half
            for(int i=0;i<=n/2;i++){
                for(int j=i;j<n/2;j++){
                    System.out.print(' ');
                }
                for(int k=0;k<(i*2)+1;k++){
                    System.out.print('*');
                }
                System.out.println();
            }
            //lower half
            for(int i=n/2;i>0;i--){
                for(int j=n/2;j>=i;j--){
                    System.out.print(' ');
                }
                for(int k=(i*2)-1;k>0;k--){
                    System.out.print('*');
                }
                System.out.println();
            }
        }
    }    
}
