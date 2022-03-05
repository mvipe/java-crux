package recursion;

import java.util.Arrays;

//bubble sort using recursion
public class bubbleSort {
    public static void main(String[] args) {
        int arr[]=new int []{13,50,40,90,30,90,12};
        System.out.println(Arrays.toString(bubble(arr,0,arr.length-1)));

    }

    private static int[] bubble(int[] arr, int si, int li) {

        if(li<=0){
            return arr;
        }

        if(si>=li){
            return bubble(arr,0,li-1);
        }else{
            if(arr[si]>arr[si+1]){
                int temp=arr[si];
                arr[si]=arr[si+1];
                arr[si+1]=temp;
            }

            return bubble(arr,si+1,li);
        }
    }


}
