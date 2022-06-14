package Heap.AdityaVerma;

import java.util.Arrays;
import java.util.PriorityQueue;
//Sort a K Sorted Array | Sort Nearly Sorted Array
public class SortNearlySortedArray {
    public static void main(String[] args) {
        int arr[]={7,10,4,3,20,15};
        System.out.println(Arrays.toString(sort(arr,3)));
    }

    static int[]  sort(int arr[],int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int curInd=0;

        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);

            if(minHeap.size()>k){

                arr[curInd]=minHeap.poll();
                curInd++;
            }
        }

        while(!minHeap.isEmpty()){
            arr[curInd]=minHeap.poll();
            curInd++;
        }

        return arr;
    }
}
