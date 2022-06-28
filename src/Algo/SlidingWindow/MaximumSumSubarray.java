package Algo.SlidingWindow;

import java.util.ArrayList;

public class MaximumSumSubarray {
    public static void main(String[] args) {
        int arr[]=new int[]{100, 200, 300, 400};
        int k=2;

        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        long res=maximumSumSubarray(k,list,4);
        System.out.println("ans="+res);
    }

    static long maximumSumSubarray(int k, ArrayList<Integer> arr, int n){
        int j=0;
        long sum=0;//current sum
        long max=Long.MIN_VALUE;
        for (int i = 0; i+k-1 != n; j++) {
            if(j-i+1==k){
                if(max==Long.MIN_VALUE){
                    sum=sum+arr.get(j);
                    max=sum;
                }else{
                    sum=sum-arr.get(i-1)+arr.get(j);
                    max=Math.max(max,sum);

                }

                i++;


            }else{

                sum+=arr.get(j);

            }
        }

        return max;
    }

    private static int maximum_sum(int[] arr, int k) {
        int j=0;
        int sum=0;//current sum
        int max=Integer.MIN_VALUE;
        for (int i = 0; i+k-1 != arr.length; j++) {
            if(j-i+1==k){
                if(max==Integer.MIN_VALUE){
                    sum=sum+arr[j];
                    max=sum;
                }else{
                    sum=sum-arr[i-1]+arr[j];
                    max=Math.max(max,sum);

                }

                i++;


            }else{

                sum+=arr[j];

            }
        }

        return max;
    }
}
