package DynamicProgramming.AdityaVerma.Lcs;


//Minimum Number of Insertion and Deletion to convert String a to String b
//https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1
public class MinimumNoOfInsAndDeletion {
    public static void main(String[] args) {

    }

    public static int minOperations(String str1, String str2)
    {
        int lcs=lcs(str1,str2);
        int ins=str1.length()-lcs;
        int del=str2.length()-lcs;

        return ins+del;
    }

    static int lcs(String x,String y){
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
}
