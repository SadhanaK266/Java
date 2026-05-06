// Question 9: Check if Two Strings are Anagrams
import java.util.HashMap;
import java.util.Scanner;

public class AnagramStrings {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str1=sc.nextLine();
        String str2=sc.nextLine();
        if(str1.length()!=str2.length()){
            System.out.println("Not an anagram");
        }

        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch1:str1.toLowerCase().toCharArray()){
            map.put(ch1,map.getOrDefault(ch1,0)+1);
        }
        for(char ch2:str2.toLowerCase().toCharArray()){
            if(!map.containsKey(ch2)){
                System.out.println("Not an anagram");
                return;
            }
            map.put(ch2,map.getOrDefault(ch2,0)-1);
        }

        for(int count:map.values()){
            if(count!=0){
                System.out.println("Not an anagram");
                return;
            }
        }
        System.out.println("It is an anagram");
    }
}
