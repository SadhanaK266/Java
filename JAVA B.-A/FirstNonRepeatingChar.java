//Question 8: First Non-Repeating Character
import java.util.HashMap;
import java.util.Scanner;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();

        HashMap<Character,Integer> map=new HashMap<>();
        //count frequency
        for(char ch:str.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(char c:str.toCharArray()){
            if(map.get(c)==1){
                System.out.println("First non-repeating: "+c);
                return;
            }
        }
    }
}
