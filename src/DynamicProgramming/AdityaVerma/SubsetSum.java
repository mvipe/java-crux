package DynamicProgramming.AdityaVerma;


import java.util.Arrays;

public class SubsetSum {
    public static void main(String[] args) {
        int arr[]=new int[]{2,3,7,8,10};
        int sum=15;

        boolean res=solveTab(arr,sum,arr.length);
        System.out.println(res);
    }

    private static boolean solveRec(int[] arr, int sum,int ind) {
        if(sum==0) return true;
        if(ind>=arr.length) return false;

        if(sum<0) return false;

        if(arr[ind]<=sum){
            return solveRec(arr,sum-arr[ind],ind+1) ||  solveRec(arr,sum,ind+1);

        }

        return solveRec(arr,sum,ind+1);
    }

    private static boolean solveRecMemo(int[] arr, int sum,int ind) {
        boolean mem[][]=new boolean [sum+1][ind+1];

        return solveRecMemo(arr,sum,ind,mem);
    }
    private static boolean solveRecMemo(int[] arr, int sum,int ind,boolean mem[][]) {
        if(sum==0) return true;
        if(ind>=arr.length) return false;

        if(sum<0) return false;

        if(mem[sum][ind]) return true;

        if(arr[ind]<=sum){
            mem[sum][ind]= solveRec(arr,sum-arr[ind],ind+1) ||  solveRec(arr,sum,ind+1);
            return mem[sum][ind];
        }

        mem[sum][ind]= solveRec(arr,sum,ind+1);
        return mem[sum][ind];
    }

    private static boolean solveTab(int[] arr, int sum,int n) {
        boolean tab[][]=new boolean[n+1][sum+1];
        //initialization
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                if(j==0) tab[i][j]=true;
                else if(i==0) tab[i][j]=false;
            }
        }

        //code
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if(arr[i-1]<=j){
                    tab[i][j] = tab[i-1][j-arr[i-1]] || tab[i-1][j];
                }

                else {
                    tab[i][j]=tab[i-1][j];
                }
            }
        }





        return tab[n][sum];
    }


}
