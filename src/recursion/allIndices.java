package recursion;

import java.util.Arrays;

public class allIndices {
    public static void main(String[] args) {
        int arr[]={6,8,1,1,8,3,4};
        System.out.println(Arrays.toString(allIndex(arr,0,8,0)));

    }

    static int[] allIndex(int [] arr,int ind,int target,int count){
        if(ind==arr.length){
            int [] baseArr=new int[count];
            return baseArr;
        }

        int []res=null;

        if(arr[ind]==target){
            res=allIndex(arr,ind+1,target,count+1);
            res[count]=ind;

        }
        else{
            res=allIndex(arr,ind+1,target,count);
        }


        return res;

    }
}
