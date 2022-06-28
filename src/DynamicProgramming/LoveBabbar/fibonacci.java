package DynamicProgramming.LoveBabbar;

import java.util.Arrays;
import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {

        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();

        int mem[]=new int[n+1];
        Arrays.fill(mem,-1);

        System.out.println(fib_so(n));

//        for (int i = 0; i < mem.length; i++) {
//            System.out.print(mem[i]+" ");
//        }



    }

    //memoization
    static int fib(int n,int [] mem){
        //base case
        if(n<=1) return n;

        if(mem[n]!=-1) return mem[n];

        mem[n]=fib(n-1,mem)+fib(n-2,mem);

        return mem[n];
    }

    //bottom up
    static int fib_bup(int n,int [] mem){
        mem[0]=0;
        mem[1]=1;

        for (int i = 2; i < n+1; i++) {
            mem[i]=mem[i-1]+mem[i-2];
        }



        return mem[n];
    }

    //space optimization
    static int fib_so(int n){
        if(n==0) return 0;
        int prev=0;
        int next=1;


        for (int i = 2; i < n+1; i++) {
            int newNext=prev+next;
            prev=next;
            next=newNext;
        }



        return next;
    }

}
