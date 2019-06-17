package io.github.seevae;/*
    name zhang;
    */

import java.util.Stack;

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

    //输入一个链表，输出该链表中倒数第k个结点
    public Node backWardsNode(int k){
        if(this.head == null ||k<0 ||k>this.getLength()){
            return null;
        }
        Node cur1 = this.head;
        Node cur2 = this.head;

        for(int i=0;i<k-1;i++){
            cur1 = cur1.next;
        }

        while(cur1.next != null){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        System.out.println(cur2.date);
        return cur2;
    }

    //将两个有序链表合并为一个新的有序链表并返回。(oj上完成)
    private Node mergeTwoLists(Node l1, Node l2) {
        Node dummyHead = new Node(0);
        Node cur = dummyHead;
        while(l1 != null && l2 != null){
            if(l1.date < l2.date){
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }else{
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }

        if(l1==null){
            cur.next = l2;
        }else{
            cur.next = l1;
        }

        return dummyHead.next;

    }

    //以给定值x为基准将链表分割为两部分,所有小于x的节点排在大于或等于x的节点之前
    public Node partition(int x){
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        Node cur = this.head;

        while(cur !=null){
            Node curNext = cur.next;
            cur.next = null;
            if(cur.date<x){
                if(beforeStart == null){
                    beforeStart = cur;
                    beforeEnd = beforeStart;
                }else {
                    beforeEnd.next = cur;
                    beforeEnd = cur;
                }
            }else
                {
                if(afterStart == null){
                    afterStart = cur;
                    afterEnd = afterStart;
                }else {
                    afterEnd.next = cur;
                    afterEnd = cur;
                }
            }
            cur = curNext;
        }

        if(beforeStart == null){
            return afterStart;
        }

        beforeEnd.next = afterStart;
        return beforeStart;
    }

    //相交链表的交点 --> 解法一: 使用栈
    private Node getIntersectionNode1(Node headA, Node headB) {
        if(headA == null && headB ==null){
            return null;
        }

        Node cur1 = headA;
        Node cur2 = headB;

        Stack s1 = new Stack();
        Stack s2 = new Stack();

        while(cur1 != null){
            s1.push(cur1);
            cur1 = cur1.next;
        }

        while(cur2 != null){
            s2.push(cur2);
            cur2 = cur2.next;
        }

        Node result = null;
        while(!s1.empty() && !s2.empty() && s1.peek() == s2.peek()){
            result = (Node)s1.pop();
            s2.pop();
        }
        return result;
    }

    //相交链表的交点 --> 解法二: 求出两条链表的长度差后用双指针
    private int getLength(Node node){
        Node cur = node;
        int length = 0;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }

    private Node getIntersectionNode2(Node headA, Node headB) {
        int length1 = getLength(headA);
        int length2 = getLength(headB);
        int gap = length1-length2;

        Node longCur = headA;
        Node shortCur = headB;

        if(length1 < length2){
            longCur = headB;
            shortCur = headA;
            gap = length2 - length1;
        }

        for(int i=0;i<gap;i++){
            longCur = longCur.next;
        }

        while(longCur != shortCur){
            longCur = longCur.next;
            shortCur = shortCur.next;
        }

        Node resultNode = longCur;
        return resultNode;
    }

    //逆序打印链表 使用栈
    public void printToTail(){
        Node cur = this.head;
        Stack<Node> stack = new Stack<Node>();

        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        while (!stack.empty()){
            System.out.print(stack.pop().date+" ");
        }

        System.out.println();
    }

    //逆序打印链表,使用递归的方式
    private void printTotail(Node head){
        if(head!= null){
            if(head.next != null){
                printTotail(head.next);
            }
            System.out.println(head.date);
        }
    }

    //删除链表中指定的节点 要求时间复杂度为O(1)
    public void deleteNode(Node head,Node toBeDelete){
        if(head ==null || toBeDelete==null){
            return ;
        }

        //被删除元素在链表的中间位置不是尾节点
        if(toBeDelete.next != null){
            Node afterNode = toBeDelete.next;
            toBeDelete.date = afterNode.date;
            toBeDelete.next = afterNode.next;
            afterNode.next = null;
        }else if(head == toBeDelete){
            //链表中只有要被删除的这一个节点
            head = null;
            toBeDelete = null;
        }else{
            Node cur = head;
            //要删除的节点是尾节点时
            while(cur.next != toBeDelete){
                cur = cur.next;
            }
            cur.next = null;
            toBeDelete.next = null;
        }
    }

}
