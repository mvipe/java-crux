package DynamicProgramming.AdityaVerma;

import java.util.Arrays;

public class ZeroOneKnapsack {

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

    //0-1 knapsack recursive
    private static int knapsack_recursive(int[] wt, int[] val, int w, int n) {
        //base case
        if(n==0 || w==0){
            return 0;
        }

        //choices
        //first choice : if weight of this element is less than bag remaining weight

        if(wt[n-1]<=w){
            //two conditions here , either take it or dont take  it
            //case -1 : take it case -2 : dont take it
            //return max of these two

            return Math.max(
                    val[n-1]+knapsack_recursive(wt,val,w-wt[n-1],n-1),//case -1 :take it
                    knapsack_recursive(wt,val,w,n-1)
            );

        }

        //second choice : if weight of this element is greater than remaining weight
        //in this case we have only one choice , dont take it

        //if(wt[n-1]>w)
        return  knapsack_recursive(wt,val,w,n-1);


    }


    //0-1 knapsack memoization
    private static int knapsack_memoization(int[] wt, int[] val, int w, int n) {
        int mem[][]=new int [w+1][n+1];
        for (int i = 0; i < mem.length; i++) {
            Arrays.fill(mem[i],-1);
        }

        return knapsack_memoization(wt,val,w,n,mem);
    }
    private static int knapsack_memoization(int[] wt, int[] val, int w, int n,int mem[][]) {
        //base case
        if(n==0 || w==0){
            return 0;
        }

        if(mem[w][n]!=-1) return mem[w][n];

        if(wt[n-1]<=w){
            mem[w][n]=Math.max(
                    val[n-1]+knapsack_memoization(wt,val,w-wt[n-1],n-1,mem),//case -1 :take it
                    knapsack_memoization(wt,val,w,n-1,mem)
            );

            return mem[w][n];
        }
        mem[w][n] = knapsack_memoization(wt,val,w,n-1);
        return mem[w][n];


    }

    //0-1 knapsack top-down


    private static int knapsack_topdown(int[] wt, int[] val, int w, int n){
        int tab[][]=new int[w+1][n+1];
        //initialize
        for (int i = 0; i < w+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if(i==0 || n==0){
                    tab[i][j]=0;
                }
            }
        }

        //choice diagram
        //w->i n->j
        for (int i = 1; i < w+1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(wt[j-1]<=i){
                    tab[i][j]=Math.max(
                            val[j-1]+tab[i-wt[j-1]][j-1],
                            tab[i][j-1]
                    );
                }

                else {
                    tab[i][j]=tab[i][j-1];
                }
            }
        }




        return tab[w][n];
    }



}
