package Algo.SlidingWindow;

import java.util.Arrays;

public class FirstNegativeNumber {
    public static void main(String[] args) {
        long arr[]=new long[]{-8, 2, 3, -6, 10};
        int k=2;

        System.out.println(Arrays.toString(printFirstNegativeInteger(arr,arr.length,k)));

    }

    public static long[] printFirstNegativeInteger(long arr[], int N, int k)
    {
        long res[]=new long[arr.length-k+1];

        int j=0;
        for (int i = 0; i <= arr.length-k; i++) {
            if(j<i){
                j=i;
            }
            for (; j < i+k; j++) {
                if(arr[j]<0){
                    res[i]=arr[j];
                    break;
                }
            }
        }

        return res;
    }
}
