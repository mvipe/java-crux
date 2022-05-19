package leetcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class kWeakestRows {
    public static void main(String[] args) {

        int mat[][]=new int[][]{
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}
        };

        int ar[]=kWeakestRows(mat,3);
        System.out.println(Arrays.toString(ar));

    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<SoldiersPair> heap=new PriorityQueue<>();
        for (int i = 0; i < mat.length; i++) {
            SoldiersPair pair=new SoldiersPair(calculateNoOfSoldiers(mat[i]),i);
            heap.add(pair);
        }

        int res[]=new int[k];
        for (int i = 0; i < k; i++) {
            res[i]=heap.poll().i;
        }

        return res;
    }

    static int calculateNoOfSoldiers(int arr[]){
        int total=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==1) total=total+1;
        }

        return total;
    }

    static class SoldiersPair implements Comparable<SoldiersPair>  {
        int noOfSoldiers;
        int i;


        public SoldiersPair(int noOfSoldiers,int i){
            this.noOfSoldiers=noOfSoldiers;
            this.i=i;
        }


        @Override
        public int compareTo(SoldiersPair o) {
            if(this.noOfSoldiers>o.noOfSoldiers) return 1;
            if(this.noOfSoldiers==o.noOfSoldiers && this.i<o.i) return 1;
            return 0;
        }
    }
}
