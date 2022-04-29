package tree.BinarySearchTree;

public class bstMain {
    public static void main(String[] args) {
//        int arr[]=new int[]{10,20,30,40,50,60,70};
//        binarySearchTree bst= new binarySearchTree(arr);
//        bst.levelOrder(bst.root);

        bst2 bst=new bst2(10);
        bst.insert(5);
        bst.insert(20);
        bst.insert(15);
        bst.insert(25);
        bst.insert(12);
        bst.insert(17);
      //  bst.insert(7);
//        bst.insert(6);
//        bst.insert(14);
//        bst.insert(12);

        bst.inorderRec(bst.root);
        bst.delete(20);
        System.out.println();
        bst.inorderRec(bst.root);


//        System.out.println(bst.search(8,bst.root));
//        System.out.println(bst.max(bst.root));
    }
}
