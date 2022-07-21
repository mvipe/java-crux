package tree.LoveBabbar.BinaryTree;

import kotlin.Pair;
import tree.BinaryTree.BinaryTree;
//https://practice.geeksforgeeks.org/problems/zigzag-tree-traversal/1
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//Boundry traversal not complete
public class TreeTraversal {
    public static void main(String[] args) {
        Node root=new Node(3);
        root.left=new Node(2);
        root.right=new Node(1);

        ArrayList<Integer> result=ZigzagTraversal(root);
        System.out.println(result.toString());

    }

//    ArrayList <Integer> verticalOrder(Node root)
//    {
//        HashMap<Integer,HashMap<Integer,ArrayList<Integer>>> nodes=new HashMap<>();
//        Queue<Pair<Node,Pair<Integer,Integer>>> q=new LinkedList<>();
//        ArrayList<Integer> ans=new ArrayList<>();
//
//        if(root==null) return ans;
//
//        q.add(new Pair<>(root,new Pair<>(0,0)));
//
//        while(!q.isEmpty()){
//            Pair<Node,Pair<Integer,Integer>> temp=q.peek();
//            Node frontNode=temp.getFirst();
//            int hd=temp.getSecond().getFirst();
//            int lvl=temp.getSecond().getSecond();
//
//            nodes.put(frontNode.data,new HashMap<>());
//        }
//    }

    ArrayList <Integer> boundary(Node node)
    {
        ArrayList<Integer> left=leftPart(node);
        ArrayList<Integer> leaf=leafPart(node);
        ArrayList<Integer> right=rightPart(node);


//
        ArrayList<Integer> res=new ArrayList<>();
        res.addAll(left);

        res.addAll(leaf);
        res.addAll(right);

        res.remove(res.size()-1);


        return res;

    }

    ArrayList <Integer> leafPart(Node node){
        if (node == null)
            return new ArrayList<>();
        if(node.left==null && node.right==null){
            ArrayList<Integer> list=new ArrayList<>();
            list.add(node.data);
            return list;
        }

        ArrayList<Integer> list=new ArrayList<>();
        list.addAll(leafPart(node.left));
        list.addAll(leafPart(node.right));





        return list;
    }

    ArrayList <Integer> rightPart(Node node){
        if(node==null || (node.right==null && node.left==null)) return new ArrayList<>();

        if(node.right!=null){
            ArrayList<Integer> res=new ArrayList<>();
            res.addAll(rightPart(node.right));
            res.add(node.data);


            return res;
        }


        ArrayList<Integer> res=new ArrayList<>();
        res.addAll(rightPart(node.left));
        res.add(node.data);


        return res;


    }

    ArrayList <Integer> leftPart(Node node){
        if(node==null || (node.right==null && node.left==null)) return new ArrayList<>();

        if(node.left!=null){
            ArrayList<Integer> res=new ArrayList<>();
            res.add(node.data);
            res.addAll(leftPart(node.left));



            return res;
        }


        ArrayList<Integer> res=new ArrayList<>();
        res.add(node.data);
        res.addAll(leftPart(node.right));



        return res;

    }




    public static ArrayList<Integer> ZigzagTraversal(Node node){
        if(node==null) {

            return new ArrayList<>();
        }

        ArrayList<Integer> result=new ArrayList<>();


        Queue<Node> queue=new LinkedList();

        //add root
        queue.add(node);

        boolean isLeftToRight=true;

        while(!queue.isEmpty()){
            //add node left and right


            int size=queue.size();
            ArrayList<Integer> ans=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                ans.add(-1);
            }


            for (int i = 0; i < size; i++) {
                Node remove=queue.poll();



                int index=isLeftToRight? i : size-i-1;

                ans.set(index,remove.data);

                if(remove.left!=null){
                    queue.add(remove.left);
                }

                if(remove.right!=null){
                    queue.add(remove.right);
                }
            }

            result.addAll(ans);

            isLeftToRight=!isLeftToRight;
        }


        return result;
    }

   static class Node
    {
        int data;
        Node left,right;
        Node(int d)
        {
            data=d;
            left=right=null;
        }
    }
}
