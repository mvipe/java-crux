package Heap.AdityaVerma;

import java.util.PriorityQueue;

public class KthSmallestElement {
    public static void main(String[] args) {
        int arr[]={7,10,4,3,20,15};
        System.out.println(kthSmallest(arr,3));
    }

    static int  kthSmallest(int arr[],int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);

            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        return maxHeap.peek();
    }
}
