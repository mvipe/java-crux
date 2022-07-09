package DynamicProgramming.AdityaVerma.unboundedknapsack;

import java.util.Arrays;

public class UnboundedKnapsack {

    //global variable

    public static void main(String[] args) {

        //set all indexes to -1 in t matrix
//        for (int i = 0; i < t.length; i++) {
//            Arrays.fill(t[i],-1);
//        }

        int wt[]=new int[]{1,3,4,5};
        int val[]=new int[]{1,4,5,7};
        int w=7;//bag total weight

        int maxProfit=knapsack_topdown(wt,val,w,wt.length);
        System.out.println(maxProfit);




    }





    private static int knapsack_topdown(int[] wt, int[] val, int w, int n){
        int tab[][]=new int[n+1][w+1];
        //initialize

            for (int i = 0; i < n+1; i++) {
                for (int j = 0; j < w+1; j++) {
                if(i==0 || j==0){
                    tab[i][j]=0;
                }
            }
        }

        //choice diagram
        //w->i n->j
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if(wt[i-1]<=j){
                    tab[i][j]=Math.max(
                            val[i-1]+tab[i-1][j-wt[i-1]],
                            tab[i-1][j]
                    );
                }

                else {
                    tab[i][j]=tab[i-1][j-1];
                }
            }
        }




        return tab[n][w];
    }



}
