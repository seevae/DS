package io.github.seevae;/*
    name zhang;
    */


class Node{
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinarySortTree {
    private Node root;

    public BinarySortTree() {
        this.root = null;
    }

    public void insert(int data){
        Node newNode = new Node(data);
        Node cur = root;
        while(true){
            if(root == null){
                root = newNode;
                return;
            }else{
                Node parent = cur;
                if(data < cur.data){
                    cur = cur.left;
                    if(cur == null){
                        parent.left = newNode;
                        return;
                    }
                }else{
                    cur = cur.right;
                    if(cur == null){
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrder(){
        this.inOrder(this.root);
    }

    //中序遍历
    public void inOrder(Node root){
        if(root == null){
            return ;
        }

        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    //构建二插搜索树
    public void creatTree(int arr[]){
        for(int i=0;i<arr.length;i++){
            this.insert(arr[i]);
        }
    }

    //前序遍历
    public void firstOrder(){
        this.firstOrder(this.root);
    }

    public void firstOrder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data+" ");
        firstOrder(root.left);
        firstOrder(root.right);
    }

}
