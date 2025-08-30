
import java.util.Scanner;

public class PrepInsta3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String vowels="aAeEiIoOuU";
        StringBuilder res=new StringBuilder();
        for(int i=0;i<str.length();i++){
            boolean isVowel=false;
            for(int j=0;j<vowels.length();j++){
                if(str.charAt(i)==vowels.charAt(j)){
                    isVowel=true;
                }
            }
            if(!isVowel){
                res.append(str.charAt(i));
            }
        }
        System.out.print(res);
    }
}
