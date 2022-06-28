package DynamicProgramming.LoveBabbar;

import java.util.Arrays;

public class MinimumElements {
    public static void main(String[] args) {
        int num[]=new int[]{1,2,3};
        int x=7;



        System.out.println("ans"+minimumElementssTab(num,x));



    }

    //Tabulation
    public static int minimumElementssTab(int[] num, int x) {
        int tab[]=new int [x+1];
        tab[0]=0;

        for (int i = 1; i < tab.length; i++) {
            int min=Integer.MAX_VALUE;
            for (int j = 0; j < num.length; j++) {
                int req=i-num[j];
                if(req>=0 && tab[req]!=-1){
                    min=Math.min(1+tab[req],min);
                }
            }

            if(min==Integer.MAX_VALUE){
                tab[i]=-1;
            }else{
                tab[i]=min;
            }



        }





        return tab[x];
    }


    //Memo
    public static int minimumElementsMemo(int[] num, int x) {

        int mem[]=new int[x+1];

        Arrays.fill(mem,-1);
        //check that ans is valid or not
        int ans=minimumElementssMemo(num,x,mem);
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        else return ans;
    }
    public static int minimumElementssMemo(int[] num, int x,int mem[]) {
        if(x==0) return 0;
        if(x<0) return Integer.MAX_VALUE;

        if(mem[x]!=-1) return mem[x];

        int min=Integer.MAX_VALUE;
        for (int i = 0; i < num.length; i++) {
            int ans=minimumElementssMemo(num,x-num[i],mem);

            if(ans!=Integer.MAX_VALUE){
                min=Math.min(min,1+ans);
            }


        }


        mem[x]=min;

        return mem[x];
    }



    //recursion
    public static int minimumElements(int[] num, int x) {
        //check that ans is valid or not
        int ans=minimumElementss(num,x);
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        else return ans;
    }
    public static int minimumElementss(int[] num, int x) {
        if(x==0) return 0;
        if(x<0) return Integer.MAX_VALUE;

        int min=Integer.MAX_VALUE;
        for (int i = 0; i < num.length; i++) {
            int ans=minimumElementss(num,x-num[i]);

            if(ans!=Integer.MAX_VALUE){
                min=Math.min(min,1+ans);
            }


        }



        return min;
    }



}
