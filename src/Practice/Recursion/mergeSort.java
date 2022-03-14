package Practice.Recursion;

import java.util.Arrays;
import java.util.Scanner;

public class mergeSort {
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();

        int arr[]=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }

        int res[]=mergesort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(res));
    }

    private static int[] mergesort(int[] arr, int s, int e) {
        if(e-s<=0){
            return new int[]{arr[s]};
        }

        if(arr.length==0){
            return new int[]{};
        }

        int m=s+(e-s)/2;
        int []left=mergesort(arr,s,m);
        int []right=mergesort(arr,m+1,e);

        //merge left and right
        int res[]=new int[left.length+right.length];

        int leftInd=0;
        int rightInd=0;
        for (int i = 0; i < res.length; i++) {
            if(leftInd>=left.length ){
                res[i]=right[rightInd];
                rightInd++;
            }else if(rightInd>=right.length){
                res[i]=left[leftInd];
                leftInd++;
            }
            else if(left[leftInd]>right[rightInd]){
                res[i]=right[rightInd];
                rightInd++;
            }else{
                res[i]=left[leftInd];
                leftInd++;
            }
        }

        return res;

    }
}
