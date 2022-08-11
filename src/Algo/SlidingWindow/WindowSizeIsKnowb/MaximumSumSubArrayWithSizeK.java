package Algo.SlidingWindow.WindowSizeIsKnowb;

public class MaximumSumSubArrayWithSizeK {
    public static void main(String[] args) {
        int arr[]=new int[]{2,3,5,2,9,7,1};
        System.out.println(maxSum(arr,3));
    }

    static int maxSum(int arr[],int k){

        int i=0;
        int j=0;

        int sum=0;
        int max=Integer.MIN_VALUE;
        while(j<arr.length){
            sum+=arr[j];
            if(j-i+1==k){
                max=Math.max(max,sum);
                sum=sum-arr[i];

                i++;j++;
            }else{
               j++;
            }
        }

        return max;
    }
}
