package Practice.Recursion;

import java.util.Scanner;

public class moveX {
    public static void main(String[] args) {
        String str;
        Scanner sc=new Scanner(System.in);
        str= sc.next();

        move(str,"",0,0);

    }

    static void move(String str,String withoutX,int countX,int ind){
        if(ind>=str.length()){
            //print
            String res=new String(withoutX);

            for (int i = 0; i < countX; i++) {
                res+='x';
            }
            System.out.println(res);
            return;
        }

        char ch=str.charAt(ind);
        if(ch=='x'){
            move(str,withoutX,countX+1,ind+1);
        }else{
            move(str,withoutX+ch,countX,ind+1);
        }
    }
}
