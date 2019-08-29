package com.qi;/*
    name zhang;
    */

public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        //前序遍历 创建树并返回数的根结点
        BinaryTree.TreeNode root = binaryTree.createTree("ABC##DE#G##F###");

        System.out.print("递归前序遍历: ");
        binaryTree.preOrder(root);
        System.out.println();

        System.out.print("非递归前序遍历: ");
        binaryTree.preNode_02(root);
        System.out.println();

        System.out.print("递归中序遍历: ");
        binaryTree.midOrder(root);
        System.out.println();

        System.out.print("非递归中序遍历: ");
        binaryTree.midNode_02(root);
        System.out.println();

        System.out.print("递归后序遍历: ");
        binaryTree.afterOrder(root);
        System.out.println();

        System.out.print("非递归后序遍历: ");
        binaryTree.afterOrder_03(root);
        System.out.println();

        System.out.print("层序遍历: ");
        binaryTree.cengxu(root);
        System.out.println();

        System.out.print("节点总个数: ");
        System.out.println(binaryTree.allNode(root));

        System.out.print("叶子节点总个数: ");
        System.out.println(binaryTree.allLeavesNode(root));

        System.out.print("查找指定的值: ");
        BinaryTree.TreeNode node = binaryTree.findVal(root,'A');
        System.out.println(node);

        System.out.print("树的高度: ");
        int high =binaryTree.getTreeHigh(root);
        System.out.println(high);

        System.out.print("第3层节点的个数");
        System.out.println(binaryTree.nodesInLineK(root,3));


    }
}
