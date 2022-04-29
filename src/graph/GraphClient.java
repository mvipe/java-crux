package graph;

import java.util.ArrayList;

public class GraphClient {
    public static void main(String[] args) {
        Graph graph=new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge("A","B",2);
        graph.addEdge("A","C",3);
        graph.addEdge("B","E",2);
        graph.addEdge("C","D",2);
        graph.addEdge("D","E",2);



        graph.display();

        graph.removeVertex("A");

        graph.removeEdge("D","C");

        graph.display();

        boolean bl=graph.hasPath("B","C","B",new ArrayList<String>());
        System.out.println(bl);

        System.out.println(graph.bfs("B","E"));
    }
}
