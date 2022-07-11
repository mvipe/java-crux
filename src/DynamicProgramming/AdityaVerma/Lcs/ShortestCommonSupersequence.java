package DynamicProgramming.AdityaVerma.Lcs;
//https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1
public class ShortestCommonSupersequence {
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        return m + n -lcs(X,Y);
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
