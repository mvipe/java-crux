package DynamicProgramming.LoveBabbar;

import java.util.Arrays;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int [] cost=new int[]{1,100,1,1,1,100,1,1,100,1};

        System.out.println("ans"+minCostClimbingStairsTabulationSpaceOptimized(cost));


    }

    //space optimized
    public static int minCostClimbingStairsTabulationSpaceOptimized(int[] cost) {

        int prev1=cost[0];
        int prev2=cost[1];


        for (int i = 2; i < cost.length; i++) {
            int newPrev2=cost[i]+Math.min(prev1,prev2);
           prev1=prev2;
           prev2=newPrev2;
        }

        return Math.min(prev1,prev2);
    }

    //bottom up
    public static int minCostClimbingStairsTabulation(int[] cost) {
        int tab[]=new int [cost.length];
        tab[0]=cost[0];
        tab[1]=cost[1];

        for (int i = 2; i < tab.length; i++) {
            tab[i]=cost[i]+Math.min(tab[i-1],tab[i-2]);
        }

        return Math.min(tab[cost.length-1],tab[cost.length-2]);
    }


    public static int minCostClimbingStairsMemo(int[] cost) {
        int n=cost.length;

        int[] mem=new int[n+1];
        Arrays.fill(mem,-1);

        return Math.min(minCostClimbingStairsMemo(cost,n-1,mem),minCostClimbingStairsMemo(cost,n-2,mem));
    }

    public static int minCostClimbingStairsMemo(int[] cost,int ind,int mem[]) {
        //base case
        if(ind==0 || ind==1){
            return cost[ind];
        }

        if(mem[ind]!=-1){
            return mem[ind];
        }

        mem[ind]=cost[ind]+Math.min(minCostClimbingStairsMemo(cost,ind-1,mem),minCostClimbingStairsMemo(cost,ind-2,mem));

        return mem[ind];
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n=cost.length;

        return Math.min(minCostClimbingStairs(cost,n-1),minCostClimbingStairs(cost,n-2));
    }

    public static int minCostClimbingStairs(int[] cost,int ind) {
        //base case
        if(ind==0 || ind==1){
            return cost[ind];
        }

        int ans=cost[ind]+Math.min(minCostClimbingStairs(cost,ind-1),minCostClimbingStairs(cost,ind-2));

        return ans;
    }

}
