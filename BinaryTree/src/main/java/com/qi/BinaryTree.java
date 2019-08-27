package com.qi;


public class BinaryTree {

    class TreeNode{
        private char val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(char val){
            this.val = val;
        }
    }

    public int i =0;
    //根据数组创建二叉树
    public TreeNode createTree(String s){
        TreeNode root = null;
        if(s.charAt(i)!='#'){
            root = new TreeNode(s.charAt(i));
            i++;
            root.left = createTree(s);
            root.right = createTree(s);
        }else{
            i++;
        }
        return root;
    }

    //前序遍历
    public void preOrder(TreeNode root){

        if(root == null){
            return;
        }

        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //中序遍历
    public void midOrder(TreeNode root){
        if(root == null){
            return;
        }
        midOrder(root.left);
        System.out.println(root.val);
        midOrder(root.right);
    }

    //后序遍历
    public void afterOrder(TreeNode root){
        if(root ==null){
            return;
        }
        afterOrder(root.left);
        afterOrder(root.right);
        System.out.println(root.val);
    }

    
}
