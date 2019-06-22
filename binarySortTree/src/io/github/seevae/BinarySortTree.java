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
        if(root == null){
            root = newNode;
        }else {
            Node cur = root;
            Node parent = null;
            while(true){
                parent = cur;
                if(data<cur.data){
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

}
