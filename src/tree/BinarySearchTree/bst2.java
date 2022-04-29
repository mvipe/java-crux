package tree.BinarySearchTree;

public class bst2 {
    public Node root;

    public bst2(){
        this.root=null;
    }

    public bst2(int data){
        Node node=new Node(data);
        this.root=node;
    }

    void insert(int key) { root = insertRec(root, key); }




    Node insertRec(Node root, int key)
    {
        if (root == null) {
            root = new Node(key);
            return root;
        }


        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);


        return root;
    }

    void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data +" ");
            inorderRec(root.right);
        }

    }

    public boolean search(int value,Node node){
        if(node==null) return false;
        if(node.data==value) return true;

        if(node.data<value){
            return search(value,node.right);
        }

        return search(value,node.left);
    }

    public  void delete(int value){
        delete(this.root,null,false,value);
    }

    private void delete(Node node,Node parent,boolean isLeft,int value){

       if(value> node.data){
           delete(node.right,node,false,value);
       }else  if(value< node.data){
           delete(node.left,node,true,value);
       }else{
           //case-1: no child
           if(node.left==null && node.right==null){
               if(isLeft){
                   parent.left=null;
               }else{
                   parent.right=null;
               }

               return;
           }

           //case -2: one child
           else if(node.right==null){
               if(isLeft){
                   parent.left=node.left;
               }else{
                   parent.right=node.left;
               }

               return;
           }

           else if(node.left==null){
               if(isLeft){
                   parent.left=node.right;
               }else{
                   parent.right=node.right;
               }

               return;
           }


           //case-3: two child
           else{
               //find left maxima
               int max=max(node.left);

               //replace the data with left maxima
               node.data=max;
               delete(node.left,node,true,max);
           }
       }

    }


    //maximum in binary search tree
    public int max(Node node){
        if(node==null) return -1;
        if(node.right==null) return node.data;

        return max(node.right);
    }
    private class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this(data,null,null);
        }

        Node(int data, Node left, Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
}
