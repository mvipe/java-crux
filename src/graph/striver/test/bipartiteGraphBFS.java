package graph.striver.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bipartiteGraphBFS {
    public static void main(String args[])
    {
        int n = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer> >();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(4).add(3);
        adj.get(3).add(4);

        adj.get(4).add(5);
        adj.get(5).add(4);

        adj.get(4).add(6);
        adj.get(6).add(4);

        adj.get(1).add(6);
        adj.get(6).add(1);



        if(checkBipartite( n,adj) == true) System.out.println("Yes Bipartite");
        else System.out.println("Not Bipartite");

    }

    static boolean checkBipartite(int V,ArrayList<ArrayList<Integer>> adj){
        boolean vis[]=new boolean[V];
        int color[]=new int[V];

        for (int i = 0; i < color.length; i++) {
            color[i]=-1;
        }

        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        vis[0]=true;
        color[0]=0;

        while (q.isEmpty()){
            Integer popEl=q.poll();

            for (Integer it:adj.get(popEl)) {
                if(vis[it]==true && color[it]==color[popEl]){
                    return false;
                }

                if(vis[it]==false){
                    q.add(it);
                    vis[it]=true;
                    color[it]=1-color[popEl];
                }
            }

        }

        return true;

    }
}
