package tree.LoveBabbar.BinaryTree;

public class isSumTree {
    class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }


    boolean isSumTree(Node root)
    {
      return false;
    }

    SumPair isBalancedd(Node node){
        if(node==null) return new SumPair(0,true);

        SumPair lp=isBalancedd(node.left);
        SumPair rp=isBalancedd(node.right);

        //previous balanced check
        boolean isBalanced=true;
        if(!lp.isSumPair || !rp.isSumPair){
            isBalanced=false;
        }

        if(isBalanced && lp.sum+rp.sum!=node.data  ){
            isBalanced=false;
        }

        if(node.left==null && node.right==null){
            isBalanced=true;
        }

        SumPair res=new SumPair(lp.sum+rp.sum+node.data,
                isBalanced);


        return res;
    }

    class SumPair{
        int sum;
        boolean isSumPair;

        SumPair(int sum,boolean isSumPair){
            this.sum=sum;
            this.isSumPair=isSumPair;
        }
    }
}
