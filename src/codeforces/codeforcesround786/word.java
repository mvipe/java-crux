package codeforces.codeforcesround786;

import java.util.Scanner;

public class word {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        String[] str=new String[n];
        for (int i = 0; i < n; i++) {
            str[i]=sc.next();
        }

        for (int i = 0; i <n ; i++) {
            System.out.println(wordp(str[i]));
        }
    }

    static int wordp(String s){
        char ch=s.charAt(0);
        int chh=(int) ch;

        int first=chh-97;

        int firstIndex=25*first+1;
        int secondCh=(int)(s.charAt(1));

        int secondIndex=secondCh-97;
        if(chh<secondCh){
            return firstIndex+secondIndex-1;
        }


        return firstIndex+secondIndex;


    }
}
