package DynamicProgramming.AdityaVerma;

import java.util.Arrays;

public class MnimumSubsetSumDifference {
    public static void main(String[] args) {
int arr[]=new int[]{3,9,12};
        System.out.println(solveTab(arr));
    }

    static int solveTab(int arr[]){
        //calculate sum
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }

        int n=arr.length;
        boolean tab[][]=new boolean[n+1][sum/2+1];
        //initialization
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                if(j==0) tab[i][j]=true;
                else if(i==0) tab[i][j]=false;
            }
        }

        //code
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < tab[0].length; j++) {
                if(arr[i-1]<=j){
                    tab[i][j] = tab[i-1][j-arr[i-1]] || tab[i-1][j];
                }

                else {
                    tab[i][j]=tab[i-1][j];
                }
            }
        }

        //check for minimum difference
        int min=Integer.MAX_VALUE;
        for (int i = 0; i <tab[0].length/2; i++) {
            if(tab[arr.length-1][i]){
                min=Math.min(min,(sum-2*i));
            }
        }


        return min;




    }
}
