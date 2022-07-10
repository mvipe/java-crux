package DynamicProgramming.AdityaVerma.Lcs;

import java.util.Arrays;

public class LongestCommonSubsequences {
    public static void main(String[] args) {
        System.out.println(solveRec("abcreefg","abcdefg"));
        System.out.println(solveMemo("abcreefg","abcdefg"));
        System.out.println(solveTabPrint("abcreefg","abcdefg"));
    }

    static int solveRec(String x,String y){
        //base case
        int n=x.length();
        int m=y.length();
        if(n==0 || m==0){
            return 0;
        }

        //choice diagram
        //char at last index is same
        if(x.charAt(n-1)==y.charAt(m-1)){
            return 1 + solveRec(x.substring(0,n-1),y.substring(0,m-1));
        }

        //char at last index is not same
            return Math.max(
                    solveRec(x.substring(0,n-1),y),
                    solveRec(x,y.substring(0,m-1))
            );


    }

    static int solveMemo(String x,String y){
        int mem[][]=new int[x.length()+1][y.length()+1];
        for (int i = 0; i < mem.length; i++) {
            Arrays.fill(mem[i],-1);
        }

        return solveMemo(x,y,mem);
    }

    static int solveMemo(String x,String y,int mem[][]){
        //base case
        int n=x.length();
        int m=y.length();
        if(n==0 || m==0){
            return 0;
        }


        if(mem[n][m]!=-1){
            return mem[n][m];
        }
        //choice diagram
        //char at last index is same
        if(x.charAt(n-1)==y.charAt(m-1)){
            mem[n][m]=1 + solveMemo(x.substring(0,n-1),y.substring(0,m-1),mem);
            return mem[n][m];
        }

        //char at last index is not same
        mem[n][m]= Math.max(
                solveMemo(x.substring(0,n-1),y,mem),
                solveMemo(x,y.substring(0,m-1),mem)
        );

        return mem[n][m];


    }

    static int solveTab(String x,String y){
        int n=x.length();
        int m=y.length();
        int tab[][]=new int[n+1][m+1];
        //initialization
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                if(i==0 || j==0){
                    tab[i][j]=0;
                }
            }
        }


        for (int i = 1; i < tab.length; i++) {
            for (int j = 1; j < tab[0].length; j++) {
               if(x.charAt(i-1)==y.charAt(j-1)){
                   tab[i][j]=1+tab[i-1][j-1];
               }else {
                   tab[i][j]=Math.max(
                         tab[i][j-1],
                         tab[i-1][j]
                   );
               }
            }
        }




        return tab[n][m];


    }

    //print the subsequences
    static int solveTabPrint(String x,String y){
        int n=x.length();
        int m=y.length();
        int tab[][]=new int[n+1][m+1];
        //initialization
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                if(i==0 || j==0){
                    tab[i][j]=0;
                }
            }
        }


        for (int i = 1; i < tab.length; i++) {
            for (int j = 1; j < tab[0].length; j++) {
                if(x.charAt(i-1)==y.charAt(j-1)){
                    tab[i][j]=1+tab[i-1][j-1];
                }else {
                    tab[i][j]=Math.max(
                            tab[i][j-1],
                            tab[i-1][j]
                    );
                }
            }
        }

        //print
        String lcs="";
        int i=tab.length-1;
        int j=tab[0].length-1;

        while(i>0 && j>0){
            if(x.charAt(i-1)==y.charAt(j-1)){
                lcs+=x.charAt(i-1);
                i--;
                j--;
            }else{
                if(tab[i-1][j]>tab[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }
        }

        System.out.println("The longest subsequences is "+lcs);




        return tab[n][m];


    }
    //return the Lcsubseq
    static String solveTabSub(String x,String y){
        int n=x.length();
        int m=y.length();
        String tab[][]=new String[n+1][m+1];
        //initialization
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                if(i==0 || j==0){
                    tab[i][j]="";
                }
            }
        }


        for (int i = 1; i < tab.length; i++) {
            for (int j = 1; j < tab[0].length; j++) {
                if(x.charAt(i-1)==y.charAt(j-1)){
                    tab[i][j]=x.charAt(i-1)+tab[i-1][j-1];
                }else {
                    String t1=tab[i][j-1];
                    String t2=tab[i-1][j];

                    if(t1.length()>t2.length()){
                        tab[i][j]=t1;
                    }else{
                        tab[i][j]=t2;
                    }
                }
            }
        }



        //reverse this string
        String res="";
        for (int i = tab[n][m].length()-1; i >=0 ; i--) {
            res+=tab[n][m].charAt(i);
        }

        return res;


    }
}
