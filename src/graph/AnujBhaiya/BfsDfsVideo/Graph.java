package graph.AnujBhaiya.BfsDfsVideo;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {
    private LinkedList<Integer> adj[];

    public Graph(int v){
        this.adj=new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i]=new LinkedList<Integer>();
        }
    }

    public int bfs(int src,int dest){
        //it will return minimum path
        boolean visited[]=new boolean[adj.length];

        Queue<Integer> queue=new LinkedList<>();
        int parent[] =new int[adj.length];//parents tells us who introduces whom
        parent[src]=-1; //here we take parent of src as -1 because no one introduces src


        queue.add(src);

        while(queue.isEmpty()){
            int cur=queue.poll();
            if(cur==dest){
                break;
            }

            for (int neighbour:adj[cur]) {
                if(!visited[neighbour]){
                    queue.add(neighbour);
                    parent[neighbour]=cur;
                }

            }
        }

        //after this loop will break we will get parent array
        int cur=dest;
        int distance=0;
        while(parent[cur]!=-1)
        {
            distance++;
            System.out.println(cur+" -> ");
            cur=parent[cur];
        }

        return distance;

    }


    //normal display function
    public void display(){
        for (int i = 0; i < adj.length; i++) {
            System.out.println(i+"->"+adj[i].toString());

        }
    }

    public void addEdge(int source,int dest){
        adj[source].add(dest);
        adj[dest].add(source);
    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of vertices and edge");

        int v=sc.nextInt();
        int e=sc.nextInt();

        Graph graph=new Graph(v);
        System.out.println("Enter "+e+" Edge");
        for (int i = 0; i < e; i++) {
            int source=sc.nextInt();
            int destination=sc.nextInt();

            graph.addEdge(source,destination);
        }

        graph.display();

    }
}
