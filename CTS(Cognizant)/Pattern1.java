import java.util.Scanner;
public class Pattern1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            int temp=1;
            for(int j=1;j<=(i*2)-1;j++){
                System.out.print(temp);
                if(j<i){
                    temp++;
                }
                else{
                    temp--;
                }
            }
            System.out.println();
        }
    }
}
