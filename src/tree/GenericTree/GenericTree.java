package tree.GenericTree;

import java.util.ArrayList;

public class GenericTree {
    private Node root;
    private int size;

    public GenericTree(){
        this.size=0;
    }
    private class Node{
        int data;
        ArrayList<Node> children;

        public Node(){
            this.data=data;
            this.children=new ArrayList<>();
        }
    }
}
