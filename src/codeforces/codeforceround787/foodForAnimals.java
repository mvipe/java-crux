package codeforces.codeforceround787;

import java.util.Scanner;

public class foodForAnimals {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int a[]=new int[n];
        int b[]=new int[n];
        int c[]=new int[n];
        int x[]=new int[n];
        int y[]=new int[n];

        for (int i = 0; i <n ; i++) {
            a[i]=sc.nextInt();
            b[i]=sc.nextInt();
            c[i]=sc.nextInt();
            x[i]=sc.nextInt();
            y[i]=sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            boolean res=isPossible(a[i],b[i],c[i],x[i],y[i]);
            if(res){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }


    }

    static boolean isPossible(int a,int b, int c,int x,int y){
        int remX=0;
        int remY=0;
        if(a<x){
            remX=x-a;
        }

        if(b<y){
            remY=y-b;
        }

        if(remX==0 && remY==0) return true;
        if(remX+remY<=c) return true;

        return false;

    }
}
