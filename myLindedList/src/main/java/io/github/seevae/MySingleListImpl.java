package io.github.seevae;/*
    name zhang;
    */

public class MySingleListImpl implements ILinked{

    class Node{
        private int date;
        private Node next;

        public Node(int data){
            this.date = data;
            this.next = null;
        }
    }

    //代表头引用,永远指向的是第一个节点
    private Node head;

    public MySingleListImpl(){
        this.head = null;
    }

    //检查下标是否合法
    public void checkIndex(int index){
        if(index<0 || index>getLength()){
            throw new UnsupportedOperationException("index位置不合法");
        }
    }

    //寻找指定下标-1处的节点
    public Node searchIndex(int index){
        checkIndex(index);
        Node cur = this.head;
        int count=0;
        while(count<index-1){
            cur = cur.next;
            count++;
        }
        return cur;
    }

    //如果是第一次插入,这是后head肯定是无指向的,所以直接让head指向节点就好
    //如果不是第一次插入,那么head之前就是有指向的,这时按照一般头插的方法插入就行了
    public void addFirst(int data) {
        Node node = new Node(data);
        //判断是否是第一次插入
        if(this.head==null){
            this.head = node;
            node.next=null;
        }else{
            node.next = this.head;
            this.head=node;
        }
    }

    public void addLast(int data) {
        Node node = new Node(data);
        Node cur = this.head;
        //第一次插入
        if(this.head ==null){
            this.head = node;
        }else{
            //找到尾节点
            while(cur.next!=null){
                cur =cur.next;
            }
            //尾部插入新的节点
            cur.next = node;
        }
    }

    //下标从0开始,插入到下标节点前的那个节点
    public boolean addIndex(int index, int data) {
        checkIndex(index);
        if(index == 0){
            addFirst(data);
            return true;
        }
        //找到目标节点前一个节点
        Node preNde = searchIndex(index);
        Node newNode = new Node(data);
        newNode.next = preNde.next;
        preNde.next = newNode;
        return true;
    }

    public boolean contains(int key) {
        Node cur = this.head;
        while(cur!=null){
            if(cur.date == key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    //找到所要删除的节点的前驱
    public Node removePre(int key){
        Node cur = this.head;
        //如果删除的节点在第一个节点的位置,ze他前面是没有节点的,这时候返回第一个节点就可以了
        if(cur.date == key){
            return this.head;
        }else {
            while(cur.next!=null){
                if(cur.next.date == key){
                    return cur;
                }
                cur = cur.next;
            }
        }
        return null;
    }

    //返回值为删除的那个值的大小
    public int remove(int key) {
        if(this.head == null){
            throw new UnsupportedOperationException("单链表为空");
        }
        int result = 0;

        Node pre = removePre(key);
        if(pre==null){
            throw new UnsupportedOperationException("没有key的前驱");
        }

        //如果删除的是第一个节点
        if(pre == this.head ){
            result = this.head.date;
            this.head = this.head.next;
            return result;
        }

        Node destDeleNode = pre.next;
        result = destDeleNode.date;
        pre.next = destDeleNode.next;
        return result;
    }


    public void removeAllKey(int key) {
        Node cur = this.head.next;
        Node pre = this.head;

        while(cur != null){
            if(cur.date == key){
                pre.next = cur.next;
                cur = pre.next;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        if(this.head.date == key){
            this.head = this.head.next;
        }
    }

    public int getLength() {
        Node cur = this.head;
        int length = 0;
        for(cur=this.head;cur!=null;cur=cur.next){
            length++;
        }
        return length;
    }

    public void display() {
        Node cur = this.head;
        for(cur=this.head;cur!=null;cur=cur.next){
            System.out.print(cur.date+" ");
        }
        System.out.println();
    }

    //引用全部置空
    public void clear() {
        while(this.head!=null){
            Node cur = this.head.next;
            this.head.next=null;
            this.head = cur;
        }
    }

    //链表练习题

    //反转单链表并返回新的头节点
    public Node reverseList() {
        //最终返回的新链表的头
        Node newHead = null;
        //记录当前节点
        Node cur = this.head;
        //当前节点的上一个节点
        Node pre = null;
       while(cur != null){
           Node curNext = cur.next;
           if(curNext == null){
               newHead = cur;
           }
           cur.next = pre;
           pre = cur;
           cur = curNext;
       }
       return newHead;
    }

    //打印链表从当前指定的节点开始
    public void show(Node node){
        Node cur = node;
        while(cur != null){
            System.out.print(cur.date+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //返回链表的中间节点,如果有两个中间节点就返回第二个
    public Node midNode(){
        Node cur = this.head;
        Node cur2 = this.head;
        int count = 0;
        while(cur != null){
            cur = cur.next;
            count++;
        }
        int end = count/2+1;
        for(int i=0;i<end-1;i++){
            cur2 = cur2.next;
        }
        System.out.println(cur2.date);
        return cur2;
    }



}
