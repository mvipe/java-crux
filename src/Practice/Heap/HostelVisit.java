package Practice.Heap;

import Heap.CustomHeap;
import Heap.GenericHeap;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

//coding block - heap challenge
//not solved
public class HostelVisit {
    public static void main(String[] args) {
        PriorityQueue heap=new PriorityQueue();

        Scanner sc=new Scanner(System.in);
        int q=sc.nextInt();
        int k= sc.nextInt();



        for(int i=0;i<q;i++){
            int type=sc.nextInt();
            if(type==2){
                printKNearestHotels(k,heap);
            }

            if(type==1){
                int x1Val= sc.nextInt();
                int x2Val= sc.nextInt();
                int calcDist=calculateDistance(x1Val,x2Val);
               heap.add(calcDist);
            }
        }




    }



    static int calculateDistance(int x1,int x2){
        return x1*x1 + x2*x2;
    }

    static void printKNearestHotels(int k,PriorityQueue<Integer> heap){
        ArrayList<Integer> rmEl=new ArrayList<>();
        for (int i = 0; i < k; i++) {
            rmEl.add(heap.remove() );
        }

        System.out.println(rmEl.get(rmEl.size()-1));

        for (int i = 0; i < k; i++) {
           heap.add(rmEl.get(i));
        }

    }
}
