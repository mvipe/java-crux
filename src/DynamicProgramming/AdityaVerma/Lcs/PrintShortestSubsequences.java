package DynamicProgramming.AdityaVerma.Lcs;

public class PrintShortestSubsequences {

    public static void main(String[] args) {
        System.out.println(solveTabPrint("abac","cab"));
    }

    static String solveTabPrint(String x,String y){
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
        String scs="";
        int i=tab.length-1;
        int j=tab[0].length-1;



        while(i>0 && j>0){
            if(x.charAt(i-1)==y.charAt(j-1)){
                scs+=x.charAt(i-1);
                i--;
                j--;
            }else{
                if(tab[i-1][j]>tab[i][j-1]){
                    scs+=x.charAt(i-1);
                    i--;
                }else{
                    scs+=y.charAt(j-1);
                    j--;
                }
            }
        }


        //remaining char in x
        while(i>0){
            scs+=x.charAt(i-1);
            i--;
        }

        while(j>0){
            scs+=y.charAt(j-1);
            j--;
        }

        //reverse the string
        String res="";
        for (int k = scs.length()-1; k >=0 ; k--) {
            res+=scs.charAt(k);
        }






        return res;


    }
}
