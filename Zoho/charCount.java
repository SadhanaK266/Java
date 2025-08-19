import java.util.*;
public class charCount{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        char[] ch=str.toCharArray();
        char c=' ';
        int count=1;
        
        for(int i=0;i<str.length();i++){
            for(int j=0;j<str.length();j++){
                if(ch[i]!=ch[j]){
                    c=ch[i];
                }
                else{
                    count++;
                }
            }
            System.out.print(c+"-"+count+" ");
            count=0;
            // System.out.print(ch[i]);
        }
    }
}