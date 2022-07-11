package DynamicProgramming.AdityaVerma.Lcs;

//https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/submissions/
//Minimum no of insertion or deletion to make this string palindrome
public class MinNoOfInsertion {
    public int minInsertions(String s) {
        return s.length()-longestPalindromeSubseq(s);
    }

    int longestPalindromeSubseq(String s) {
        //reverse string
        String s2="";
        for (int i = s.length()-1; i >=0 ; i--) {
            s2+=s.charAt(i);
        }
        return lcs(s,s2);
    }

    int lcs(String x,String y){
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
