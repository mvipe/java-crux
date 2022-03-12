package Practice.Recursion;

import java.util.Scanner;

//coding block
//Take as input S, a string. Write a function that removes all consecutive duplicates. Print the value returned.
public class removeDuplicates {
    public static void main(String[] args) {
        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.next();

        System.out.println(remove(str));

    }

    static String remove(String s){
        if(s.length()<=1 ){
            return s;
        }

        if(s.charAt(0)==s.charAt(1)){
            return remove(s.substring(1));
        }else{
            return s.charAt(0)+remove(s.substring(1));
        }
    }

}
