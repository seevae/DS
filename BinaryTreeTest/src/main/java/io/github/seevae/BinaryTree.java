package io.github.seevae;/*
    name zhang;
    */

public class BinaryTree {

    class TreeNode{
        private char value;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(char value){
            this.value = value;
        }
    }

    //二叉树的前序遍历
    public void binaryTreePrevOrder(TreeNode root){
        if(root == null){
            return ;
        }

        System.out.print(root.value+" ");
        binaryTreePrevOrder(root.left);
        binaryTreePrevOrder(root.right);
    }

    //二叉树的中序遍历
    public void binaryTreeInOrder(TreeNode root){
        if(root == null){
            return ;
        }

        binaryTreeInOrder(root.left);
        System.out.print(root.value+" ");
        binaryTreeInOrder(root.right);
    }

    //二叉树的后序遍历
    public void binaryTreePostOrder(TreeNode root){
        if(root == null){
            return ;
        }

        binaryTreeInOrder(root.left);
        binaryTreeInOrder(root.right);
        System.out.print(root.value+" ");
    }


    public int i = 0;

    //根据字符串创建一个二叉树,#代表空节点  前序遍历: ABC##DE#G##F###
    public TreeNode createTestTree(String s){
        TreeNode root = null;
        if(s.charAt(i) != '#'){
            root = new TreeNode(s.charAt(i));
            i++;
            root.left = createTestTree(s);
            root.right = createTestTree(s);
        }else{
            i++;
        }
        return root;
    }

    // 结点个数
    //思路:
    //后序遍历:  左子树节点个数 + 右子树节点个数 + 根结点
    int getSize(TreeNode root){
        if(root == null){
            return 0;
        }

        return getSize(root.left) + getSize(root.right)+1;
    }

    // 叶子结点个数
    int getLeafSize(TreeNode root){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right==null){
            return 1;
        }

        return getLeafSize(root.left)+getLeafSize(root.right);
    }
    

}
