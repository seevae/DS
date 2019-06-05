package io.github.seevae;/*
    name zhang;
    */

public interface IArrayList<E> {
    //是否为空
    boolean isEmpty(SeqList<E> SL);
    //初始化
    void SListInit(SeqList<E> SL, int cap);
    //销毁
    void SListDestroy(SeqList<E> SL);
    //当前顺序表长度
    int SListLength(SeqList<E> SL);
    //头插
    void SListPushFront(SeqList<E> SL, Object data);
    //头删
    void SListPopFront(SeqList<E> SL);
    //尾插
    void SListPushTail(SeqList<E> SL, Object data);
    //尾删
    void SListPopTail(SeqList<E> SL);
    //在pos所在的下标做数据插入
    void SListInsert(SeqList<E> SL, int pos, Object data);
    //删除pos所在下标的数据
    void SListErase(SeqList<E> SL, int pos);

    // 找从 0 开始的第一个，如果找到了，返回数据所在的下标
    // 如果没找到返回 -1
    int SeqListFind(SeqList<E> SL, Object data);

    // 删除第一个遇到的 data
    void SeqListRemove(SeqList<E> SL, Object data);

    // 删除所有遇到的 data
    void SeqListRemoveAll(SeqList<E> SL, Object data);

    // 修改，pos 所在的下标
    void SeqListModify(SeqList<E> SL, int pos, Object data);

    // 打印
    void SeqListPrint(SeqList<E> SL);

    // 内部接口,判断是否需要进行扩容
    void CheckCapacity(SeqList<E> SL);

    // 冒泡排序
    void SeqListBubbleSort(SeqList<E> SL);

    // 二分查找（前提是数据有序）
    // 如果找到，返回数据所在下标，如果没找到，返回 -1
    int SeqListBinarySearch(SeqList<E> SL, Object data);
}
