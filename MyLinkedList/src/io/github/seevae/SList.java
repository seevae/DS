package io.github.seevae;
/*
    name zhang;
    */

import java.util.Map;

public class SList<E> implements SListMethod<E> {

    public class Node {
        private E data;
        private Node next;

        public Node() {

        }

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    @Override
    public void InitSeqList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void DestroySeqList(SList<E> sList) {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void PushBackSeqList(E data) {
        if (head == null) {
            head = new Node(data, null);
            tail = head;
            size++;
        } else {
            Node newNode = new Node(data, null);
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    @Override
    public void PushFrontSeqList(E data) {
        if (head == null) {
            Node newNode = new Node(data, null);
            head = newNode;
            tail = head;
            size++;
        } else {
            Node newNode = new Node(data, null);
            newNode.next = head;
            head = newNode;
            size++;
        }

    }

    @Override
    public void PopBackSeqList() {
        if (head == null) {
            System.out.println("该链表已经为空不可进行删除操作");
            return;
        }

        if (head.next == null) {
            head = null;
            size--;
            return;
        }

        Node cur = head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        cur.next = null;
        tail = cur;
        size--;
    }

    @Override
    public void PopFrontSeqList() {
        if (head == null) {
            System.out.println("该链表已经为空不可进行删除操作");
            return;
        }

        Node cur = head.next;
        head.next = null;
        head = cur;
        size--;
    }

    @Override
    public void InsertSeqList(int pos, E data) {
        if(pos == 1 || head == null){
            PushFrontSeqList(data);
            return;
        }

        int i = 1;
        Node cur = head;
        while(i<pos-1){
            cur = cur.next;
            i++;
        }

        Node newNode = new Node(data,null);
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }

    @Override
    public void EraseSeqList(E data) {
        Node deletNode = FindSeqList(data);
        Node cur = head;
        while(cur.next != deletNode){
            cur = cur.next;
        }
        cur.next = deletNode.next;
        deletNode.next = null;
        size--;
    }

    @Override
    public Node FindSeqList(E data) {
        for(Node cur = head; cur != null; cur=cur.next){
            if(cur.data == data || cur.data.equals(data)){
                return cur;
            }
        }
        System.out.println("所要查找的元素不存在");
        return null;
    }

    @Override
    public void RemoveSeqList(E data) {

        Node prev = null;
        Node cur = head;


        while(cur != null && cur.data != data){
            prev = cur;
            cur = cur.next;
        }

        prev.next = cur.next;
        cur.next = null;
        size--;
    }

    @Override
    public void PrintSeqList(SList<E> sList) {
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }
        System.out.println();
    }

    //Java中的所有方法传递的都是值,没有传址这一概念,所以这种方式虽然也对,但是看起来会较为繁琐
//    @Override
//    public void PushBackSeqList(SList<E> sList,E data) {
//        if(sList.head == null){
//            sList.head = new Node(data,null);
//            sList.tail = head;
//        }else{
//            Node newNode = new Node(data,null);
//            sList.tail.next = newNode;
//            sList.tail = newNode;
//        }
//    }
}
