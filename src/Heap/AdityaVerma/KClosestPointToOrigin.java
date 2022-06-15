package Heap.AdityaVerma;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointToOrigin {
    public static void main(String[] args) {
        Point[] p=new Point[]{
                new Point(1,3),
                new Point(-2,2),
                new Point(5,8),
                new Point(0,1)
        };

        int k=2;

        Point[] res=kClosestPoints(p,k);

        for (int i = 0; i < res.length; i++) {
            System.out.println("x="+res[i].x +" y="+res[i].y);
        }


    }

    private static Point[] kClosestPoints(Point[] p, int k) {
        PriorityQueue<PointsDistancePair> maxHeap=new PriorityQueue<>((a, b)->a.distance<b.distance?1:-1);

        for (int i = 0; i < p.length; i++) {
            double calcDistance=Math.sqrt(p[i].x*p[i].x + p[i].y+p[i].y);

            maxHeap.add(new PointsDistancePair(p[i],calcDistance));

            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        Point[] res=new Point [k];
        int i=0;
        while (!maxHeap.isEmpty()){
            res[i]=maxHeap.poll().point;
            i++;
        }

        return res;

    }


    static class Point{
        int x;
        int y;

        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    static class PointsDistancePair implements Comparable<PointsDistancePair>{
        Point point;
        double distance;

        PointsDistancePair(Point point,double distance){
            this.point=point;
            this.distance=distance;
        }


        @Override
        public int compareTo(PointsDistancePair o) {
            if(this.distance==o.distance) return 0;
            else if(this.distance>o.distance) return 1;
            else return -1;
        }
    }
}
