package tree.LoveBabbar.BinaryTree;
//https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1
public class BalanceTreeOrNot {

    public static void main(String[] args) {

    }

    boolean isBalanced(Node root)
    {
       return isBalancedd(root).isBalanced;
    }

    HeightPair isBalancedd(Node node){
        if(node==null) return new HeightPair(0,true);

        HeightPair lp=isBalancedd(node.left);
        HeightPair rp=isBalancedd(node.right);

        //previous balanced check
        boolean isBalanced=true;
        if(!lp.isBalanced || !rp.isBalanced){
            isBalanced=false;
        }

        if(isBalanced && Math.abs(lp.height-rp.height)>1  ){
            isBalanced=false;
        }

        HeightPair res=new HeightPair(1+Math.max(lp.height,rp.height),
                isBalanced);


        return res;
    }

    class HeightPair{
        int height;
        boolean isBalanced;

        public HeightPair(int height,boolean isBalanced){
            this.height=height;
            this.isBalanced=isBalanced;
        }
    }

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
}
