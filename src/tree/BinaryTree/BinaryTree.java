package tree.BinaryTree;

import java.util.*;

public class BinaryTree {
    Node root;
    int size;

    public BinaryTree(){
        Scanner sc=new Scanner(System.in);
        this.root=takeInput(sc,null,false);
    }

    private Node takeInput(Scanner sc,Node parent,boolean isLeftOrRight){

        if(parent==null){
            System.out.println("Enter the data for root node");

        }else{
            if(isLeftOrRight){
                System.out.println("Enter the data for left node");
            }else{
                System.out.println("Enter the data for right node");
            }

        }


        int nodeData=sc.nextInt();
        Node node=new Node(nodeData);
        this.size++;


        boolean choice=false;
        System.out.println("Do you have left child of"+ node.data);
        choice=sc.nextBoolean();

        if(choice){
            node.left=takeInput(sc,node,true);
        }

        choice=false;
        System.out.println("Do you have right child of"+ node.data);
        choice=sc.nextBoolean();

        if(choice){
            node.right=takeInput(sc,node,true);
        }


        return node;

    }

    void printPostorder(Node node)
    {
        if (node == null)
            return;

        // first recur on left subtree
        printPostorder(node.left);

        // then recur on right subtree
        printPostorder(node.right);

        // now deal with the node
        System.out.print(node.data + " ");
    }

    void printPreorder(Node node)
    {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.data + " ");

        /* then recur on left subtree */
        printPreorder(node.left);

        /* now recur on right subtree */
        printPreorder(node.right);
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

    public boolean isBTaBST(){
       return isBTaBST(this.root,Integer.MIN_VALUE,Integer.MAX_VALUE);

    }

    //check that a binary tree is bst or not
    private boolean isBTaBST(Node node, int lowerBound,int upperBound){
        if(node==null) return true;

        if(node.data>lowerBound && node.data<upperBound){
            boolean res=isBTaBST(node.left,lowerBound,node.data);

            if(!res){
                return false;
            }else{
                return isBTaBST(node.right,node.data,upperBound);
            }
        }


        return false;
    }


    public int height(Node node){
        if(node==null) return -1;

        int leftHeight=height(node.left);
        int rightHeight=height(node.right);

        return 1+Math.max(leftHeight,rightHeight);
    }

    public void display(){
        this.display(root);
    }

    private void display(Node node){

    }

    void printInorder(Node node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.data + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    int  sumOfLefNode(Node node)
    {
        if (node == null)
            return 0;
        if(node.left==null && node.right==null){
            return node.data;
        }


        int leftSum=sumOfLefNode(node.left);
        int rightSum=sumOfLefNode(node.right);

        return leftSum+rightSum;
    }

    int diameter(Node node){
        //this approach is not optimum because we are finding same node height again and again
        if(node==null) return 0;

        //case-1 : when diameter is passing through root
        int leftH=height(node.left);
        int rightH=height(node.right);

        //case-2 : when diameter is not passing through root , but it is on left subtree
        int leftDiameter=diameter(node.left);
        //case-3 : when diameter is not passing through root , but it is on right subtree
        int rightDiameter=diameter(node.right);


        return Math.max(Math.max(leftH+rightH+2,leftDiameter),rightDiameter);

    }

    public int diameterBetter(){
        return this.diameterBetter(this.root).diameter;
    }

    private DiaPair diameterBetter(Node node){
        if(node==null){
            DiaPair bp=new DiaPair(-1,0);
            return bp;
        }

        DiaPair lp=this.diameterBetter(node.left);
        DiaPair rp=this.diameterBetter(node.right);

        DiaPair mp=new DiaPair();
        mp.height=Math.max(lp.height+rp.height+2,Math.max(lp.diameter,rp.diameter));
        mp.diameter=Math.max(lp.height+rp.height+2,Math.max(lp.diameter,rp.diameter));

        return mp;
    }



    void inorderIterative(Node node){


    }

    private class DiaPair{
        int height;
        int diameter;

       DiaPair(){

       }

       DiaPair(int height,int diameter){
           this.height=height;
           this.diameter=diameter;
       }
    }


    //Binary Tree Node
    private class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
           this(data,null,null);
        }

        Node(int data,Node left,Node right){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
}
