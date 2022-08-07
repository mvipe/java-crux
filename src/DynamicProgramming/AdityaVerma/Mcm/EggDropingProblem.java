package DynamicProgramming.AdityaVerma.Mcm;

import java.util.Arrays;

public class EggDropingProblem {
    public static void main(String[] args) {
        System.out.println(solveMemo(7,10000));
    }
    static int solveMemo(int e,int f){
        int mem[][]=new int [e+1][f+1];
        for (int i = 0; i < mem.length; i++) {
            Arrays.fill(mem[i],-1);
        }

        return solveMemoOptimized(e,f,mem);
    }
    static int solveMemoOptimized(int e,int f,int mem[][]){
        //base case
        if(f==0 || f==1) return f;

        if(e==1) return f;

        if(mem[e][f]!=-1) return mem[e][f];
        //
        int min=Integer.MAX_VALUE;

        for (int k=1;k<=f;k++){

            int break_case=mem[e-1][k-1];
            if(break_case==-1) {
                mem[e-1][k-1]=solveMemoOptimized(e-1,k-1,mem);
                break_case=mem[e-1][k-1];
            }

            int not_break_case=mem[e][f-k];
            if(not_break_case==-1){
                mem[e][f-k]=solveMemoOptimized(e,f-k,mem);
                not_break_case=mem[e][f-k];
            }
            int temp=1+Math.max(
                    break_case,not_break_case
            );

            min=Math.min(min,temp);
        }

        mem[e][f]=min;
        return mem[e][f];
    }
    static int solveMemo(int e,int f,int mem[][]){
        //base case
        if(f==0 || f==1) return f;

        if(e==1) return f;

        if(mem[e][f]!=-1) return mem[e][f];
        //
        int min=Integer.MAX_VALUE;

        for (int k=1;k<=f;k++){
            int temp=1+Math.max(
                    solveMemo(e-1,k-1,mem),
                    solveMemo(e,f-k,mem)
            );

            min=Math.min(min,temp);
        }

        mem[e][f]=min;
        return mem[e][f];
    }



    static int solveRec(int e,int f){
        //base case
        if(f==0 || f==1) return f;

        if(e==1) return f;

        //
        int min=Integer.MAX_VALUE;

        for (int k=1;k<=f;k++){
            int temp=1+Math.max(
                  solveRec(e-1,k-1),
                  solveRec(e,f-k)
            );

            min=Math.min(min,temp);
        }

        return min;
    }
}
