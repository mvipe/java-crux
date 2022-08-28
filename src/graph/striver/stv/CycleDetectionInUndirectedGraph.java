package graph.striver.stv;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CycleDetectionInUndirectedGraph {
    public static void main(String[] args) {

    }

    //using bfs

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[]=new boolean[V];
        for (int i = 0; i < adj.size(); i++) {
            if(!vis[i]) {
                if(isCycle(i,V,adj,vis)) return true;
            }
        }

        return false;
    }
    public boolean isCycle(int node,int V, ArrayList<ArrayList<Integer>> adj,boolean vis[]) {

        int parents[]=new int[V];

        boolean res=false;

        Queue<Integer> queue=new LinkedList<>();
        queue.add(node);
        vis[node]=true;
        parents[node]=-1;

        while(!queue.isEmpty()){
            int rm= queue.remove();

            for (int it : adj.get(rm)){
                if(!vis[it]){
                    queue.add(it);
                    vis[it]=true;
                    parents[it]=rm;
                }else if(parents[rm]!=it){
                    return true;
                }
            }
        }

        return res;
    }

    //using dfs
    public boolean isCycle2(int node,int V, ArrayList<ArrayList<Integer>> adj,boolean vis[]) {

        int parents[]=new int[V];

        boolean res=false;

        Stack<Integer> stack=new Stack<>();
        stack.add(node);
        vis[node]=true;
        parents[node]=-1;

        while(!stack.isEmpty()){
            int rm= stack.pop();

            for (int it : adj.get(rm)){
                if(!vis[it]){
                    stack.add(it);
                    vis[it]=true;
                    parents[it]=rm;
                }else if(parents[rm]!=it){
                    return true;
                }
            }
        }

        return res;
    }
}
