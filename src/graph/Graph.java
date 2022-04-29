package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {

    private class Vertex{
        HashMap<String,Integer> neighbours;
        Vertex(){
            neighbours=new HashMap<>();
        }
    }

    HashMap<String, Vertex> vertexes;

    public Graph(){
        vertexes=new HashMap<>();
    }

    public int numVertex(){
        //will give the number of vertex in this graph.
        return this.vertexes.size();

    }

    public void addVertex(String vName){
        Vertex vertex=new Vertex();
        vertexes.put(vName,vertex);
    }

    public void removeVertex(String vName){
        //3 steps for removing vertex from a graph
        //step-1: Find neighbours of vertex
        //step-2: Remove vertex from its neighbors
        //step-3: Remove vertex


        Vertex vtx=vertexes.get(vName);
        //step-1
        ArrayList<String> neighbors=new ArrayList<>(vtx.neighbours.keySet());

        //step-2
        for(String key:neighbors){
            Vertex temp=vertexes.get(key);
            temp.neighbours.remove(vName);
        }

        //step-3
        vertexes.remove(vName);
    }

    public boolean containsVertex(String vName){
        //it will tell whether any vertex is present or not
        return this.vertexes.containsKey(vName);

    }

    public int numEdge(){
        int count=0;
        ArrayList<String> keys=new ArrayList<>(vertexes.keySet());
        for(String key:keys){
            Vertex vtx=vertexes.get(key);
            count+=vtx.neighbours.size();
        }

        return count/2;
    }

    public boolean containsEdge(String vName1,String vName2 ){
        Vertex vtx1=vertexes.get(vName1);
        Vertex vtx2=vertexes.get(vName2);
        if(vtx1==null || vtx2==null || !vtx1.neighbours.containsKey(vName2)  ){
            return false;
        }

        return true;
    }

    public void addEdge(String vName1,String vName2,int cost){
        Vertex vtx1=vertexes.get(vName1);
        Vertex vtx2=vertexes.get(vName2);

        if(vtx1==null || vtx2==null || vtx1.neighbours.containsKey(vName2)  ){
            return ;
        }

        vtx1.neighbours.put(vName2,cost);
        vtx2.neighbours.put(vName1,cost);

    }
    public void removeEdge(String vName1,String vName2){
        Vertex vtx1=vertexes.get(vName1);
        Vertex vtx2=vertexes.get(vName2);

        if(vtx1==null || vtx2==null || !vtx1.neighbours.containsKey(vName2)  ){
            return ;
        }

        //remove edge
        vtx1.neighbours.remove(vName2);
        vtx2.neighbours.remove(vName1);
    }

    public void display(){
        ArrayList<String> keys=new ArrayList<>(vertexes.keySet());
        System.out.println("----------");

        for(String key:keys){
            Vertex vtx=vertexes.get(key);
            System.out.println(key + " : "+vtx.neighbours);
        }

        System.out.println("----------");
    }

    public boolean hasPath(String vName1,String vName2, String curVertex,ArrayList<String> path){
        if(curVertex.equals(vName2)){
            return true;
        }

        boolean res=false;
        Vertex vtx=vertexes.get(curVertex);
        ArrayList<String> keys=new ArrayList<>(vtx.neighbours.keySet());
        for(String key:keys){
            if(!path.contains(key)){
                path.add(key);
                if(hasPath(vName1,vName2,key,path)){
                    return true;
                }
                path.remove(key);
            }
        }

        return res;

    }

    private class Pair{
        String vName;
        String psf;//path so far

        Pair(String vName,String psf){
            this.vName=vName;
            this.psf=psf;
        }
    }

    public boolean bfs(String src,String dst){

        HashMap<String ,Boolean> processed=new HashMap<>();
        //src-source dst-destination
        LinkedList<Pair> queue=new LinkedList<>();//will work as a queue

        //create a new pair
        Pair sp=new Pair(src,dst);

        //put the new pair in the queue
        queue.addLast(sp);

        while(!queue.isEmpty()){
            Pair rp=queue.removeFirst();

            if(processed.containsKey(rp.vName)){
                continue;
            }

            processed.put(rp.vName,true);

            //check direct edge

            if(containsEdge(rp.vName,dst)){
                return true;
            }

            //check for neighbors
            Vertex rpvtex=vertexes.get(rp.vName);//rpvtex-removed vertex
            ArrayList<String> nbrs=new ArrayList<>(rpvtex.neighbours.keySet());


            //process only for unprocessed
            for(String nbr:nbrs){
                if(!processed.containsKey(nbr)){
                    Pair np=new Pair(nbr,rp.psf+nbr);

                    queue.addLast(np);
                }
            }
        }

        return false;


    }


}
