package tree.LoveBabbar.BinaryTree;

//https://practice.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/1

public class isIdentical {

    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }}

    class Solution
    {
        //Function to check if two trees are identical.
        boolean isIdentical(Node root1, Node root2)
        {
            if(root1==null && root2==null) return true;

            if(root1!=null && root2==null) return false;

            if(root1==null && root2!=null) return false;

            boolean left=isIdentical(root1.left,root2.left);
            boolean right=isIdentical(root1.right,root2.right);

            boolean value=root1.data == root2.data;

            if(left && right && value){
                return true;
            }else{
                return false;
            }


        }

    }
}
