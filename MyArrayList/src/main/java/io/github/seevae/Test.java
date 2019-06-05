package io.github.seevae;/*
    name zhang;
    */

public class Test {

    public static void main(String[] args) {
            SeqList<Integer> list = new SeqList<Integer>();
//            list.isEmpty(list);
            list.SListInit(list,10);
//            System.out.println(list.SListLength(list));
            list.SListPushFront(list,1);
            list.SListPushFront(list,2);
            list.SListPushFront(list,3);
            list.SListPopFront(list);
            list.SListPopFront(list);
            list.SListPopFront(list);
            list.SListPushTail(list,1);
            list.SListPushTail(list,2);
            list.SListPushTail(list,3);
//            list.SListPopTail(list);
//            list.SListPopTail(list);
//        list.SListPopTail(list);

        list.SListInsert(list,2,5);
        list.SListInsert(list,0,5);
        list.SListInsert(list,3,5);

        list.SListErase(list,0);
        list.SListErase(list,4);

        int index = list.SeqListFind(list,5);
      //  System.out.println(index);

        list.SListPushTail(list,1);
        list.SListPushTail(list,5);
        list.SListPushTail(list,8);

        list.SeqListRemoveAll(list,5);
        list.SeqListRemove(list,1);

        list.SListPushTail(list,3);
        list.SListPushTail(list,9);
        list.SListPushTail(list,10);
        list.SeqListBubbleSort(list);

        System.out.println(list.SeqListBinarySearch(list,10));

        list.SeqListPrint(list);

    }
}
