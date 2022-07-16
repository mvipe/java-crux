package tree.LoveBabbar.BinaryTree;
//https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1
public class TreeDiameter {

    class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

    class Solution {
        // Function to return the diameter of a Binary Tree.
        int diameter(Node root) {
            return diameterBetter(root).diameter;
        }

        private DiaPair diameterBetter(Node node){
            if(node==null){
                DiaPair bp=new DiaPair(0,0);
                return bp;
            }

            DiaPair lp=this.diameterBetter(node.left);
            DiaPair rp=this.diameterBetter(node.right);

            DiaPair mp=new DiaPair();
            mp.height=1+Math.max(lp.height,rp.height);
            mp.diameter=Math.max(lp.height+rp.height+1,Math.max(lp.diameter,rp.diameter));

            return mp;
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
    }

}
