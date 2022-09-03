package graph.striver;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://www.algoexpert.io/questions/dijkstra's-algorithm
public class DijkstraAlgo {

    public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        int dist[]=new int[edges.length];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[start]=0;
        PriorityQueue<Node> minHeap=new PriorityQueue<>();
        minHeap.add(new Node(start,0));

        while(!minHeap.isEmpty()){
            Node rmVal=minHeap.poll();

            for(int[] el : edges[rmVal.node]){
                if(rmVal.distance+el[1]<dist[el[0]]){
                    dist[el[0]]=rmVal.distance+el[1];
                    minHeap.add(new Node(el[0],rmVal.distance+el[1]));
                }
            }
        }

        for(int i=0;i<dist.length;i++){
            if(dist[i]==Integer.MAX_VALUE){
                dist[i]=-1;
            }
        }

        return dist;



    }

    class Node implements Comparable<Node>{
        int node;
        int distance;//weighgt

        public Node(int node,int distance){
            this.node=node;
            this.distance=distance;
        }

        @Override
        public int compareTo(Node o) {
            if(this.distance==o.distance) return 0;
            else if(this.distance>o.distance) return 1;
            else return -1;
        }
    }
}

