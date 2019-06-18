package io.github.seevae;/*
    name zhang;
    */

public class TestDemo {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.createTestTree("ABC##DE#G##F###");
        binaryTree.binaryTreeInOrder(root);
    }
}
