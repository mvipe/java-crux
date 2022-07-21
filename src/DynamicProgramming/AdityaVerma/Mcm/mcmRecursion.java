package DynamicProgramming.AdityaVerma.Mcm;

import java.util.Arrays;

public class mcmRecursion {
    public static void main(String[] args) {
        int arr[]=new int[]{40,20,30,10,30};
        System.out.println(solveMem(arr,1,arr.length-1));
    }

    static int solveMem(int arr[],int i,int j){
        int mem[][]=new int [arr.length+1][arr.length+1];
        for (int k = 0; k < mem.length; k++) {
            Arrays.fill(mem[k],-1);
        }

        return solveMem(arr,i,j,mem);
    }

    static int solveMem(int arr[],int i,int j,int mem[][]){
        if(i>=j) return 0;

        int min=Integer.MAX_VALUE;

        if(mem[i][j]!=-1) return mem[i][j];

        for (int k = i; k <= j-1; k++) {
            //calculate temp ans
            int tempAns=solveMem(arr,i,k,mem) + solveMem(arr,k+1,j,mem) + arr[i-1]*arr[k]*arr[j];

            //compare
            if(tempAns<min){
                min=tempAns;
            }
        }

        mem[i][j]=min;

        return mem[i][j];
    }

    //using recursion
    static int solveRec(int arr[],int i,int j){
        if(i>=j) return 0;

        int min=Integer.MAX_VALUE;

        for (int k = i; k <= j-1; k++) {
            //calculate temp ans
            int tempAns=solveRec(arr,i,k) + solveRec(arr,k+1,j) + arr[i-1]*arr[k]*arr[j];

            //compare
            if(tempAns<min){
                min=tempAns;
            }
        }

        return min;
    }
}
