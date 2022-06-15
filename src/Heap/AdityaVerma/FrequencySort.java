package Heap.AdityaVerma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

//top k frequent number
//arr = [1,1,1,3,2,2,4]
//k=2
//ans=[1,2]
public class FrequencySort {
    public static void main(String[] args) {
        int arr[]=new int[]{1,1,1,1,3,4,2,4,3,3,2};
        int res[]=frequencySort(arr);

        System.out.println(Arrays.toString(res));
    }

    static int[] frequencySort(int arr[]){
        //(value,frequency)
        HashMap<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int freq=0;
            if(map.get(arr[i])==null){
                freq=1;
            }else freq=map.get(arr[i])+1;

            map.put(arr[i],freq);

        }

        System.out.println("size"+map.size());

        PriorityQueue<Pair> minHeap=new PriorityQueue<>();

        ArrayList<Integer> valueSet=new ArrayList<>(map.keySet());

        for(int el:valueSet){
            minHeap.add(new Pair(el,map.get(el)));

        }



        int i=arr.length-1;
        while(!minHeap.isEmpty()){
            System.out.println("poll");

            Pair pollPair=minHeap.poll();
            int value=pollPair.value;
            int freq=pollPair.freq;


            while(freq!=0){
                arr[i]=value;
                freq--;
                i--;
            }

        }

        return arr;
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
