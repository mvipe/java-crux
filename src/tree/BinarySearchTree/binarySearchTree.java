package tree.BinarySearchTree;

import tree.BinaryTree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class binarySearchTree {
    public Node root;

    public binarySearchTree(int arr[]){
        this.root=constructBST(arr,0,arr.length-1);
    }

    private Node constructBST(int arr[],int li,int hi){
        if(li>hi) return null ;

        int m=(li+hi)/2;

        //create a new node
        Node node=new Node(arr[m]);

        node.left=constructBST(arr,li,m-1);
        node .right=constructBST(arr,m+1,hi);

        return node;
    }

    public void levelOrder(Node node){
        if(node==null) return ;

        Queue<Node> queue=new LinkedList();

        //add root
        queue.add(node);

        while(!queue.isEmpty()){
            //add node left and right
            Node remove=queue.poll();
            if(remove.left!=null){
                queue.add(remove.left);
            }

            if(remove.right!=null){
                queue.add(remove.right);
            }

            int data=remove.data;

            System.out.println(data);
        }
    }

    private class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this(data,null,null);
        }

        Node(int data,Node left,Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
}
