package graph.striver.test;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class topoSortBFS {
    public static void main(String[] args) {
        ArrayList <ArrayList< Integer >> adj = new ArrayList < > ();

        // adding new arraylists to 'adj' to add neighbour nodes
        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList < > ());
        }


        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(3).add(1);
        adj.get(2).add(3);


        topoSort(6,adj);
    }

    private static void topoSort(int n, ArrayList<ArrayList<Integer>> adj) {
        int toposort[]=new int[n];
        int topoInd=-1;
        boolean vis[]=new boolean[n];


        //calculating the indegree
        int indegree[]=new int[n];
        for (int i = 0; i <indegree.length ; i++) {
            indegree[i]=0;
        }

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list=adj.get(i);
            for(Integer it:list){
                indegree[it]=indegree[it]+1;
            }
        }

        System.out.print("Indegree  : ");
        for (int it:indegree) {
            System.out.print(it+" ");
        }
        System.out.println();

        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i <indegree.length ; i++) {
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int popEl=queue.poll();

            topoInd++;
            toposort[topoInd]=popEl;

            //decrease indegree by 1 from adj node of popEl
            for(int it:adj.get(popEl)){
                indegree[it]--;
                if(indegree[it]==0){
                    queue.add(it);
                }
            }

        }

        //print the toposort
        System.out.print("Toposort  : ");
        for (int it:toposort) {
            System.out.print(it+" ");
        }
    }
}
