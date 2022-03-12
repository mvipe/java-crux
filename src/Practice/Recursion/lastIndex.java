package Practice.Recursion;

import java.util.Scanner;

public class lastIndex {
    public static void main(String[] args) {

        int n;
        Scanner sc=new Scanner(System.in);

        n=sc.nextInt();

        int arr[]=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }

        int m=sc.nextInt();

        System.out.println(lastIndex(arr,m,0));


    }

    static int lastIndex(int[]arr ,int n,int ind){

        if(ind==arr.length || arr.length==0){
            return -1;
        }

        int temp=-1;
        if(arr[ind]==n){
            temp=ind;
        }

        //search element after this
        int t=lastIndex(arr,n,ind+1);

        if(t!=-1){
            temp=t;
        }

        return temp;
    }
}
