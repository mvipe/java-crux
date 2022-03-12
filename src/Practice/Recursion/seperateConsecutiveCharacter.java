package Practice.Recursion;

import java.util.Scanner;

//coding block
//Take as input str, a string. Write a recursive function which returns a new string in which all duplicate consecutive characters are separated by a ‘ * ’. E.g. for “hello” return “hel*lo”. Print the value returned

public class seperateConsecutiveCharacter {
    public static void main(String[] args) {
        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.next();

        System.out.println(seperate(str));

    }

    static String seperate(String s){
        if(s.length()<=1 ){
            return s;
        }

        if(s.charAt(0)==s.charAt(1)){
            return s.charAt(0)+"*"+seperate(s.substring(1));
        }else{
            return s.charAt(0)+seperate(s.substring(1));
        }
    }

}
