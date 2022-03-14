package Practice.Recursion;

import java.util.Scanner;

//not solved fully

public class tillingProblem {
    public static void main(String[] args) {
        int t;
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();

        int []m=new int[t];
        int []n=new int[t];

        for (int i = 0; i < t; i++) {
            m[i]=sc.nextInt();
            n[i]=sc.nextInt();
        }

        for(int i=0;i<t;i++){
            System.out.println(noOfWays(m[i],n[i],n[i]));
        }
    }

    static int noOfWays(int m,int n,int tiles){
        if(m==1 || n==1){
            if(n==1 && m>1 ){
                int r=noOfWays(m-1,tiles,tiles);
                return r;
            }
            else return 1;
        }

        int res=0;
        if(m>=tiles){
            res+=noOfWays(m,n-1,tiles);
        }
        if(n>=tiles){
            res+=noOfWays(m-1,n,tiles);
        }

        return res;
    }

}
