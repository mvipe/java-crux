package tree.BinaryTree;

public class BinaryTreeMain {
    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        binaryTree.levelOrder(binaryTree.root);

        System.out.println(binaryTree.height(binaryTree.root));

        System.out.println(binaryTree.isBTaBST());

        binaryTree.printInorder(binaryTree.root);
        binaryTree.inorderIterative(binaryTree.root);

        System.out.println("sum of leaf node"+binaryTree.sumOfLefNode(binaryTree.root));

        System.out.println("diameter"+binaryTree.diameter(binaryTree.root));
    }
}
