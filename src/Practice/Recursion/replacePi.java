package Practice.Recursion;

import java.util.Scanner;

public class replacePi {
    public static void main(String[] args) {
        String str[];
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        str=new String[n];

        for (int i = 0; i < n; i++) {
            str[i]=sc.next();
        }

        for (int i = 0; i <n ; i++) {
            System.out.println(replace(str[i]));
        }


    }

    static String replace(String s){
        if(s.length()<=1){
            return s;
        }

        if(s.substring(0,2).equals("pi")){
            return "3.14"+replace(s.substring(2));
        }
        else{
            return s.charAt(0)+replace(s.substring(1));
        }
    }
}
