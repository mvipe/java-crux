package Practice.Recursion;

import java.util.Scanner;

public class subsequences {
    public static void main(String args[]) {
        // Your Code Here
        String str;
        Scanner sc=new Scanner(System.in);
        str=sc.next();
        print("",str);
        System.out.println(count("",str));


    }

    static int count(String p,String up){
        if(up.isEmpty()){
            return 1;
        }

        int res=0;
        res+=count(p,up.substring(1));
        res+=count(p+up.charAt(0),up.substring(1));

        return res;
    }

    static void print(String p,String up){
        if(up.isEmpty()){
            System.out.print(p+" ");
            return;
        }


        print(p,up.substring(1));
        print(p+up.charAt(0),up.substring(1));


    }
}
