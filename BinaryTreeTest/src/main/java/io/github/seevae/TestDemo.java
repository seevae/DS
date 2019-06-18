package io.github.seevae;/*
    name zhang;
    */

public class TestDemo {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.createTestTree("ABC##DE#G##F###");
        binaryTree.binaryTreePrevOrder(root);
        System.out.println();
        binaryTree.binaryTreeInOrder(root);
        System.out.println();
        binaryTree.binaryTreePostOrder(root);
        System.out.println();
        System.out.println(binaryTree.getSize(root));
        System.out.println(binaryTree.getLeafSize(root));
        System.out.println(binaryTree.getKLevelSize(root,3));



    }
}
