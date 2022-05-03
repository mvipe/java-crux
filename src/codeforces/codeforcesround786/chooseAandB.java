package codeforces.codeforcesround786;

import java.util.ArrayList;
import java.util.Scanner;
//
public class chooseAandB {
    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int x[]=new int[n];
        int y[]=new int[n];

        for (int i = 0; i < n; i++) {
            x[i]=sc.nextInt();
            y[i]=sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int ress[]=res(x[i],y[i]);
            System.out.println(ress[0]+" "+ress[1]);
        }


    }

    static int[] res(int x,int y){
        if(y%x!=0) return new int[]{0,0};
        if(y==x) return new int[]{1,1};
        int fac=y/x;

        ArrayList<Integer> list=factors(fac);

        for (int i = 0; i <list.size() ; i++) {
            int mul=fac;
            int b=list.get(i);
            int a=0;

            int myMul=1;


            while(myMul<=mul){
                if(mul==myMul) return new int[]{a,b};

                myMul=myMul*b;
                a=a+1;
            }

        }

        return new int[]{0,0};



    }

    static ArrayList<Integer> factors(int n){
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 2; i <= n; ++i) {
            if (n % i == 0) {
                list.add(i);
            }
        }

        return list;
    }
}
