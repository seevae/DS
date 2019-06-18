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

        binaryTreePostOrder(root.left);
        binaryTreePostOrder(root.right);
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

    // 第 k 层结点个数
    //思想: 左子树第k-1层的节点个数 + 右子树第k-1层的节点个数
    int getKLevelSize(TreeNode root, int k){
        if(root == null){
            return 0;
        }else if(k==1){
            return 1;
        }

        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
    }

    // 查找，依次在二叉树的 根、左子树、右子树 中查找 value，如果找到，返回结点，否则返回 null
    //先在左子树找,再在右子树找
    public TreeNode find(TreeNode root, int value){
        if(root == null){
            return null;
        }

        if(root.value == value){
            return root;
        }

       TreeNode res =  find(root.left,value);
        if(res != null){
            return res;
        }

        res = find(root.right,value);
        if(res != null){
            return res;
        }

        return null;
    }

    //二叉树的高度
    //求左子树高度和右子树高度然后取较高的一个+1
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeigth = height(root.left);
        int rightHeigth = height(root.right);
        return leftHeigth>rightHeigth?leftHeigth+1:rightHeigth+1;
    }

}
