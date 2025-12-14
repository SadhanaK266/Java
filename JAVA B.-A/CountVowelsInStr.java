import java.util.Scanner;

public class CountVowelsInStr {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int count=0;
        for(char c:str.toLowerCase().toCharArray()){
            if("aeiou".indexOf(c)!=-1){
                count++;
            }
        }
        System.out.print(count);
    }
}
