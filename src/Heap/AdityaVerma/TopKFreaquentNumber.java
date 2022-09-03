package Heap.AdityaVerma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

//top k frequent number
//arr = [1,1,1,3,2,2,4]
//k=2
//ans=[1,2]
public class TopKFreaquentNumber {
    public static void main(String[] args) {
        int arr[]=new int[]{1,1,1,1,3,4,2,4,3,3,2};
        int res[]=topKFrequent(arr,2);

        System.out.println(Arrays.toString(res));
    }

    static int[] topKFrequent(int arr[],int k){
        //(value,frequency)
        HashMap<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],1+map.getOrDefault(arr[i],0));
        }

        PriorityQueue<Pair> minHeap=new PriorityQueue<>();

        ArrayList<Integer> valueSet=new ArrayList<>(map.keySet());

        for(int el:valueSet){
            minHeap.add(new Pair(el,map.get(el)));

            if(minHeap.size()>k){
                minHeap.poll();
            }
        }


        int res[]=new int[k];
        int i=0;
        while(!minHeap.isEmpty()){
            res[i]=minHeap.poll().value;
            i++;
        }

        return res;
    }

    static class  Pair implements Comparable<Pair>{
        int value;
        int freq;

        Pair(int value,int freq){
            this.value=value;
            this.freq=freq;

        }


        @Override
        public int compareTo(Pair o) {
            if(this.freq==o.freq) return 0;
            else if(this.freq>o.freq) return 1;
            else return -1;
        }
    }
}
