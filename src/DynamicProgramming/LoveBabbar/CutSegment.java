package DynamicProgramming.LoveBabbar;

import java.util.Arrays;

public class CutSegment {
    public static void main(String[] args) {
        int res=cutSegmentsTab(7,5,2,2);
        System.out.println(res);

        res=cutSegmentsTab(8,3,3,3);
        System.out.println(res);

        res=cutSegmentsTab(8,1,4,4);
        System.out.println(res);
    }

    //tab
    public static int cutSegmentsTab(int n, int x, int y, int z) {
        int tab[]=new int[n+1];
        tab[0]=0;
        for (int i = 1; i < tab.length; i++) {
            int max=Integer.MIN_VALUE;
            if(i-x>=0 && tab[i-x]!=-1){
                max=Math.max(max,tab[i-x]);
            }

            if(i-y>=0 && tab[i-y]!=-1){
                max=Math.max(max,tab[i-y]);
            }

            if(i-z>=0 && tab[i-z]!=-1){
                max=Math.max(max,tab[i-z]);
            }



            if(max==Integer.MIN_VALUE) {
                tab[i]=-1;
            }else{
                tab[i]=1+max;
            }
        }





        if(tab[n]==-1) return 0;


        return tab[n];


    }

    //Memo

    public static int cutSegmentsMainMemo(int n, int x, int y, int z) {
        int mem[]=new int[n+1];
        Arrays.fill(mem,-1);

        int res=cutSegmentsSolveMemo(n,x,y,z,mem);
        if(res==Integer.MIN_VALUE) return 0;
        else return res;
    }

    public static int cutSegmentsSolveMemo(int n, int x, int y, int z,int mem[]) {
        if(n==0) return 0;

        int max=Integer.MIN_VALUE;

        if(mem[n]!=-1) return mem[n];
        if(n-x>=0){
            max=Math.max(max,cutSegmentsSolveMemo(n-x,x,y,z,mem));
        }

        if(n-y>=0){
            max=Math.max(max,cutSegmentsSolveMemo(n-y,x,y,z,mem));
        }

        if(n-z>=0){
            max=Math.max(max,cutSegmentsSolveMemo(n-z,x,y,z,mem));
        }



        if(max==Integer.MIN_VALUE){
            mem[n]=max;
            return mem[n];
        }

        mem[n]=1+max;

        return mem[n];


    }


    //recursion
    public static int cutSegmentsMain(int n, int x, int y, int z) {
        int res=cutSegmentsSolve(n,x,y,z);
        if(res==Integer.MIN_VALUE) return 0;
        else return res;
    }

    public static int cutSegmentsSolve(int n, int x, int y, int z) {
        if(n==0) return 0;

        int max=Integer.MIN_VALUE;
        if(n-x>=0){
            max=Math.max(max,cutSegmentsSolve(n-x,x,y,z));
        }

        if(n-y>=0){
            max=Math.max(max,cutSegmentsSolve(n-y,x,y,z));
        }

        if(n-z>=0){
            max=Math.max(max,cutSegmentsSolve(n-z,x,y,z));
        }

        if(max==Integer.MIN_VALUE) return max;

        else return 1+max;


    }
}
