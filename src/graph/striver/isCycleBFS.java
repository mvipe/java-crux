package graph.striver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class isCycleBFS {
    public static class NodePair{
        int node;
        int parent;

        public NodePair(int node,int parent){
            this.node=node;
            this.parent=parent;
        }
    }
    public static boolean isCycle(int V, ArrayList < ArrayList < Integer >> adj) {


        boolean vis[] = new boolean[V];
        Queue< NodePair > q = new LinkedList< >();

        q.add(new NodePair(0,-1));
        vis[0] = true;

        while (!q.isEmpty()) {
            NodePair nodePair = q.poll();


            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for (Integer it: adj.get(nodePair.node)) {
                if (vis[it] == false) {
                    vis[it] = true;
                    q.add(new NodePair(it,nodePair.node));
                }else if(vis[it] ==true && it!=nodePair.parent){
                    return true;
                }
            }
        }

        return false;


    }

    static void printAns(ArrayList < Integer > ans) {
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
    public static void main(String args[]) {

        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);
        adj.get(4).add(3);
        adj.get(3).add(4);



        System.out.println(isCycle(5,adj));





    }

}
