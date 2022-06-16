package DynamicProgramming.AdityaVerma;

import java.util.Arrays;

public class ZeroOneKnapsack {

    //global variable
    static int t[][]=new int[100][100];
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
        //base case
        if(n==0 || w==0){
            return 0;
        }


        if(wt[n-1]<=w){



            t[n][w] = Math.max(
                    val[n-1]+knapsack_memoization(wt,val,w-wt[n-1],n-1),//case -1 :take it
                    knapsack_memoization(wt,val,w,n-1)
            );

            return t[n][w];

        }

        t[n][w]=knapsack_memoization(wt,val,w,n-1);

        return  t[n][w];


    }

    //0-1 knapsack top-down
    private static int knapsack_topdown(int[] wt, int[] val, int w, int n){
        //initialize
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < w+1; j++) {
                if(i==0 || n==0){
                    t[i][j]=0;
                }
            }
        }

        //choice diagram
        //w->i n->j
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if(wt[i-1]<=j){

                    t[i][j]=Math.max(val[i-1]+t[i-1][j-wt[i-1]],
                            t[i-1][j]);
                }

                else{
                    t[i][j]=t[i-1][j];
                }
            }
        }




        return t[n][w];
    }



}
