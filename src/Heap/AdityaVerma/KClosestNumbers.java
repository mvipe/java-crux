package Heap.AdityaVerma;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestNumbers {
    public static void main(String[] args) {
        int arr[]=new int[]{5,6,7,8,9};
        int k=3;
        int x=7;

        int res[]=kClosest(arr,k,x);
        System.out.println(Arrays.toString(res));
    }

    private static int[] kClosest(int[] arr, int k, int x) {
        PriorityQueue<Pair> maxHeap=new PriorityQueue<>((a,b)->(Math.abs(a.value-x)<Math.abs(b.value-x))?1:-1);

        for (int i = 0; i < arr.length; i++) {

            maxHeap.add(new Pair(arr[i],Math.abs(arr[i]-x)));

            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        int res[]=new int [k];
        int i=0;
        while (!maxHeap.isEmpty()){
            res[i]=maxHeap.poll().value;
            i++;
        }

        return res;
    }

    static class Pair{
        int value;
        int valueWithMinus;

        Pair(int value,int valueWithMinus){
            this.value=value;
            this.valueWithMinus=valueWithMinus;
        }
    }
}
