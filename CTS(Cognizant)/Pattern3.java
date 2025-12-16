import java.util.Scanner;

public class Pattern3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<(n*2)-1;i++){
            int temp=1;
            if(i<n){
                for(int j=0;j<=i;j++){
                    System.out.print(temp);
                    temp++;
                }
                System.out.println();
            }
            else{
                for(int k=i;k<(n*2)-1;k++){
                    System.out.print(temp);
                    temp++;
                }
                System.out.println();
            }
            
        }
    }
}
