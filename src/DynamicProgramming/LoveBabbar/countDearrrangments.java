package DynamicProgramming.LoveBabbar;

import java.util.Arrays;
//https://www.codingninjas.com/codestudio/problems/count-derangements_873861?leftPanelTab=1&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar
public class countDearrrangments {
    static int mod=1000000007;
    public static void main(String[] args) {
        System.out.println(countDerangementsMemo(744));
        System.out.println(countDerangementsSO(744));

    }

    //space optimized
    public static long countDerangementsSO(int n) {
       long prev1=0;
       long prev2=1;
       if(n==1)
           return prev1;
       if (n==2)
           return prev2;


        for (int i = 3; i < n+1; i++) {
            long prevPrev2=prev2;
            prev2=(((i-1)%mod) *(prev1%mod +prevPrev2%mod))%mod;

            prev1=prevPrev2;


        }






        return prev2;
    }

    //tab
    public static long countDerangementsTab(int n) {
        long tab[]=new long[n+1];
        tab[1]=0;
        tab[2]=1;

        for (int i = 3; i < tab.length; i++) {
            tab[i]=(((i-1)%mod) *(tab[i-1] +tab[i-2]))%mod;
        }




        return tab[n];
    }

    //memoization
    public static long countDerangementsMemo(int n) {
        long mem[]=new long[n+1];
        Arrays.fill(mem,-1);

        return countDerangementsMemo(n,mem);
    }
    public static long countDerangementsMemo(int n,long mem[]) {
        if(n==1)
            return 0;
        if(n==2)
            return 1;

        if(mem[n]!=-1)
            return mem[n];

        long ans=(((n-1)%mod) *((countDerangementsMemo(n-1,mem)%mod) +(countDerangementsMemo(n-2,mem)%mod)))%mod;

        mem[n]=ans;
        return mem[n];
    }
    //recursion
    public static long countDerangements(int n) {
        if(n==1)
            return 0;
        if(n==2)
            return 1;

        long ans=(((n-1)%mod) *((countDerangements(n-1)%mod) +(countDerangements(n-2)%mod)))%mod;

        return ans;
    }
}
