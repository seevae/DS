package com.qi;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
        System.out.print(root.val+" ");
        midOrder(root.right);
    }

    //后序遍历
    public void afterOrder(TreeNode root){
        if(root ==null){
            return;
        }
        afterOrder(root.left);
        afterOrder(root.right);
        System.out.print(root.val+" ");
    }

    //求全部节点的个数
    //总结点个数 = 左子树节点个数 + 右子树节点个数 + 1
    public int allNode(TreeNode root){
        if(root == null){
            return 0;
        }

        return allNode(root.left)+allNode(root.right)+1;
    }

    //求叶子节点的个数
    public int allLeavesNode(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left==null && root.right ==null){
            return 1;
        }

        return allLeavesNode(root.left)+allLeavesNode(root.right);
    }

    //求第k层节点个数
    //假如求第4层. 从第一层算起,k-3后才到达真正统计结点个数的层
    public int nodesInLineK(TreeNode root,int k){
        if(root == null){
            return 0;
        }else if(k==1){
            return 1;
        }

        return nodesInLineK(root.left,k-1)+nodesInLineK(root.right,k-1);
    }

    //在二叉树中查找指定的值
    //现在左子树中进行查找, 再到右子树中进行查找
    public TreeNode findVal(TreeNode root,int val){
        if(root ==null){
            return null;
        }

        if(root.val == val){
            return root;
        }

        //在左子树中寻找
        TreeNode treeNode = findVal(root.left,val);
        if(treeNode != null){
            return treeNode;
        }

        treeNode = findVal(root.right,val);
        if(treeNode != null){
            return treeNode;
        }

        return null;
    }

    //求树的高度
    public int getTreeHigh(TreeNode root){
        if(root == null){
            return 0;
        }

        //求左子树的高度
        int left = getTreeHigh(root.left);
        int right = getTreeHigh(root.right);
        return left>right?left+1:right+1;
    }

    //非递归前序遍历二叉树
    public void preNode_02(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode top = null;
        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                System.out.print(root.val+" ");
                root = root.left;
            }
            top = stack.pop();
            root = top.right;
        }
    }

    //非递归中序遍历
    public void midNode_02(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode top = null;

        while(cur != null || !stack.empty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            top = stack.pop();
            System.out.print(top.val+" ");
            cur = top.right;
        }
    }

    //非递归后续遍历
    public void afterOrder_03(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode pre = null;

        while(cur!=null || !stack.empty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.peek();
            if(cur.right == null ||pre.right == null){
                stack.pop();
                System.out.print(cur.val+" ");
                pre = cur;
                cur = null;
            }else {
                cur = cur.right;
            }
        }
    }

    //层序遍历二叉树
    public void cengxu(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if(root != null){
            queue.offer(root);
        }

        //开始装入左右子树并层序遍历
        while(!queue.isEmpty()){
            TreeNode topNode = queue.peek();
            System.out.print(topNode.val+" ");
            if(topNode.left != null){
                queue.offer(topNode.left);
            }
            if(topNode.right != null){
                queue.offer(topNode.right);
            }
            queue.poll();
        }
    }



}
