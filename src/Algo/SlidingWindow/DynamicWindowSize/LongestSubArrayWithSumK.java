package Algo.SlidingWindow.DynamicWindowSize;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int arr[]=new int[]{10, 5, 2, 7, 1, 9};
        System.out.println(lenOfLongSubarr(arr,arr.length,15));
    }

    //it works only for positive numbers array
    public static int lenOfLongSubarr (int arr[], int N, int k) {


        int i=0;
        int j=0;
        int max=Integer.MIN_VALUE;//it represent max size of subarray with sum k

        int curSUm=0;
        while (j<N ){
            curSUm=curSUm+arr[j];

            //3 cases
            if(curSUm<k){
                j++;
            }else if(curSUm==k){
                max=Math.max(max,(j-i+1));

                j++;
            }else if(curSUm>k){
                j++;

                while (curSUm>k){
                    curSUm-=arr[i];
                    i++;
                }
            }
        }




        return max;

    }
}
