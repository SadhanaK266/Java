import java.util.*;
public class DiamondPattern{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the height : ");
        int n=sc.nextInt();
        int mid=n/2;
        if(n%2==0){
            //top
            for(int i=1;i<=mid;i++){
                for(int l=i;l<=mid-1;l++){
                    System.out.print(' ');
                }
                for(int j=i;j<i*2;j++){
                    System.out.print((i%2!=0)?((j%2!=0)?'1':'*'):((j%2==0)?'1':'*'));
                }
                for(int k=1;k<=i;k++){
                    // System.out.print((i%2!=0)?((k%2!=0)?'1':'*'):((k%2==0)?'1':'*'));
                    System.out.print((i+k)%2==0 ?'1':'*' );
                }
                for(int r=i;r<=mid-1;r++){
                    System.out.print(' ');
                }
                System.out.println();
            }
            //bottom
            for(int i=1;i<=mid;i++){
                for(int l=1;l<i;l++){
                    System.out.print(' ');
                }
                for(int j=i;j<=mid;j++){
                    System.out.print((i%2!=0)?((j%2!=0)?'1':'*'):((j%2==0)?'1':'*'));
                }
                for(int k=i;k<=mid;k++){
                    System.out.print((i%2!=0)?((k%2!=0)?'1':'*'):((k%2==0)?'*':'1'));
                }
                for(int r=1;r<i;r++){
                    System.out.print(' ');
                }
                System.out.println();
            }
        }
        else{
            //top
            for(int i=1;i<=mid+1;i++){
                for(int l=i;l<mid+1;l++){
                    System.out.print(' ');
                }
                for(int j=1;j<=i;j++){
                    System.out.print((j%2!=0)?'1':'*');
                }
                for(int k=1;k<i;k++){
                    System.out.print((i%2==0)?((k%2!=0)?'1':'*'):((k%2!=0) ?'*':'1'));
                }
                System.out.println();
            }
            //bottom
            for(int i=1;i<=mid;i++){
                for(int l=1;l<=i;l++){
                    System.out.print(' ');
                }
                for(int j=i;j<=mid;j++){
                    System.out.print((i%2!=0)?(j%2!=0 ? '1':'*'):(j%2!=0 ?'*':'1'));
                }
                for(int k=i;k<mid;k++){
                    System.out.print(k%2!=0 ?'1':'*');
                }
                System.out.println();
            }
        }
        sc.close();
        
    }
}