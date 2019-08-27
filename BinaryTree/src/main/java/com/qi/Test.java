package com.qi;/*
    name zhang;
    */

public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        //创建树并返回数的根结点
        BinaryTree.TreeNode root = binaryTree.createTree("ABC##DE#G##F###");

        binaryTree.preOrder(root);

    }
}
