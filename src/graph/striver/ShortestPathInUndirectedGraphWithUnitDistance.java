package graph.striver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInUndirectedGraphWithUnitDistance {
    public static void main(String[] args) {

    }

    private void shortestPath(ArrayList<ArrayList<Integer>> adj, int N, int src)
    {

        int[] dist = new int[N];
        for(int i = 0; i < N; i++)
            dist[i] = Integer.MAX_VALUE;

        Queue<Integer> q=new LinkedList<>();


        dist[src] = 0;
        q.add(src);

        while(q.isEmpty()==false)
        {
            int node = q.poll();

            for(int it:adj.get(node)){
                if(dist[node] + 1 < dist[it]){
                    dist[it] = dist[node] + 1;
                    q.add(it);
                }
            }
        }

        for(int i = 0;i < N;i++) {
            System.out.print(dist[i] + " ");
        }
    }
}
