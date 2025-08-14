import java.util.Scanner;

public class String1 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        StringBuilder res=new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='a'|| str.charAt(i)=='e'||str.charAt(i)=='i' || str.charAt(i)=='o' || str.charAt(i)=='u' || str.charAt(i)=='A' ||str.charAt(i)=='E' ||str.charAt(i)=='O' || str.charAt(i)=='U'){
                continue;
            }
            else{
                res.append(str.charAt(i)+" ");
                // System.out.print(str.charAt(i)+" ");
            }
        }
        System.out.println(res);
    }
}
