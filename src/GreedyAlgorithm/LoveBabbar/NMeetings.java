package GreedyAlgorithm.LoveBabbar;

import Heap.AdityaVerma.FrequencySort;

import java.util.ArrayList;
import java.util.Collections;

public class NMeetings {
    public static void main(String[] args) {
        int start[]=new int[]{3,0,5,8,5,1};
        int end[]=new int[]{4,6,7,9,9,2};
        int N=6;
        System.out.println(maxMeetings(start,end,N));
    }

    public static int maxMeetings(int start[], int end[], int n)
    {
        ArrayList<Pair> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new Pair(start[i],end[i]));
        }

        Collections.sort(list);

        int res=1;
        int k=0;
        for (int i=1;i<n;i++){
            if(list.get(i).startTime>list.get(k).endTime){
                k=i;
                res++;
            }
        }

        return res;
    }

    static class Pair implements Comparable<Pair>{
        int startTime;
        int endTime;

        public Pair(int startTime,int endTime){
            this.endTime=endTime;
            this.startTime=startTime;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.endTime==o.endTime) return 0;
            else if(this.endTime>o.endTime) return 1;
            else return -1;
        }


    }
}
