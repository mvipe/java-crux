package Practice.Recursion;

import java.util.Scanner;

import static java.lang.Math.pow;

//coding block
//Take as input str, a number in form of a string. Write a recursive function to convert the number in string form to number in integer form. E.g. for “1234” return 1234. Print the value returned.


public class convertToInt {
    public static void main(String args[]) {
        // Your Code Here
        String str;
        Scanner sc=new Scanner(System.in);

        str=sc.next();

        System.out.println(convertToInt(str));


    }

    static int convertToInt(String str){
        if(str.length()==0){
            return 0;
        }

        String s= String.valueOf(str.charAt(0));
        int firstzInd=Integer.valueOf(s);

        int res= (int) (firstzInd*pow(10,str.length()-1));

        return res+ convertToInt(str.substring(1));

    }
}
