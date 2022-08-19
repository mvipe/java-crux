package Algo.SlidingWindow.WindowSizeIsKnowb;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstNegativeIntegerInEveryWindowSize {
    public static void main(String[] args) {
        long[] arr=new long[]{-8, 2, 3, -6, 10};
        System.out.println(Arrays.toString(printFirstNegativeInteger(arr,arr.length,2)));
    }

    static long[] printFirstNegativeInteger(long arr[], int N, int k)
    {
        if(N<k){
            return new long[0];
        }
        long[] res=new long[N-k+1];
        Arrays.fill(res,0);
        ArrayList<Long> negativeNumbers=new ArrayList<>();

        int i=0;
        int j=0;
        while(j<N){
            if(arr[j]<0){
                negativeNumbers.add(arr[j]);
            }

            if(j-i+1==k){
                res[i]=negativeNumbers.size()!=0?negativeNumbers.get(0):0;

                if(arr[i]<0  ){
                    negativeNumbers.remove(0);
                }

                i++;
                j++;

            }
            else{
                j++;
            }
        }

        return res;
    }
}
