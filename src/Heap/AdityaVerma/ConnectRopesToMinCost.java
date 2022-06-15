package Heap.AdityaVerma;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ConnectRopesToMinCost {
    public static void main(String[] args) {
        int arr[]=new int[]{1,2,3,4,5};

        int res=minCost(arr);

        System.out.println(res);
    }

    static int  minCost(int arr[]){
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();

        //add all element from arr in the min heap
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
        }

        int cost=0;
        while(minHeap.size()>1){
            int first=minHeap.poll();
            int second=minHeap.poll();

            int curCost=first+second;
            cost+=curCost;
            minHeap.add(curCost);
        }

        return cost;
    }
}
