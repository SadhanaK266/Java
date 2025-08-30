import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
// import java.util.*;

public class set {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Set<String> s=new HashSet<>();
        s.add("AND");
        s.add("or");
        s.add("the");
        s.add("dac");
        s.add("dafaosj");
        s.add("Sjabfk b");
        s.add("lafnaoskn");
        s.add("dkhasifb");
        s.add("pkojfowqjfo");
        s.add("pwdnas");

        for(String i: s){
            System.out.print(i+" ");
        }
    }
}
