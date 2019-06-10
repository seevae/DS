package io.github.seevae;/*
    name zhang;
    */

public class HeadSingleListC implements CLinkList{

    class Node{
        private int data;
        private Node next;
        //这个构造方法专门用来生产头节点,因为头节点中是没有数据的(这里使用-1标注)
        public Node(){
            this.data = -1;
            this.next = null;
        }
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public HeadSingleListC(){
        this.head = new Node();
        this.head.next = this.head;
    }

    public void addFirst(int data) {
        Node node = new Node(data);
        node.next = head.next;
        head.next = node;
    }

    public void addLast(int data) {
        Node node = new Node(data);
        Node cur = this.head;
        while(cur.next!=this.head){
            cur = cur.next;
        }
        node.next = this.head;
        cur.next = node;
    }

    public int getLength(){
        int length = 0;
        Node cur = this.head;
        for(;cur.next!=this.head;cur=cur.next){
            length++;
        }
        return length;
    }

    public boolean checkIndex(int index){
        if(index <0 || index > this.getLength()){
            return false;
        }
        return true;
  }

    public boolean addIndex(int index, int data) {
        this.checkIndex(index);
        Node cur = this.head;
        for(int i=index;i>0;i--){
            cur = cur.next;
        }
        Node newNode = new Node(data);
        newNode.next = cur.next;
        cur.next = newNode;
        return true;
    }

    public boolean contains(int key) {
        Node cur = this.head.next;
        for(;cur!=this.head;cur=cur.next){
            if(cur.data == key){
                return true;
            }
        }
        return false;
    }

    //找到要删除节点的前一个节点
    private Node findPre(int key){
        Node cur = this.head;
        while(cur.next!=this.head){
            if(cur.next.data == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    public int remove(int key) {
        Node prenode = this.findPre(key);
//        for(Node cur=this.head.next;cur!=this.head;cur=cur.next){
//            if(cur.data == key){
//                prenode.next = cur.next;
//                return 1;
//            }
//        }
        if(prenode == null){
            return 0;
        }
        Node del = prenode.next;
        prenode.next = del.next;
        return 1;
    }

    public void removeAllKey(int key) {
        Node cur = this.head;
        Node del = cur.next;
        while(del.next != this.head){
            if(del.data == key){
                cur.next = del.next;
                del = cur.next;
            }else{
                cur = del;
                del = del.next;
            }
        }
    }

    public void display() {
        Node cur = this.head.next;
        while(cur!= this.head){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void clear() {
        while (this.head.next != this.head){
            Node node = this.head.next;
            this.head.next = node.next;
        }
        this.head = null;
    }
}
