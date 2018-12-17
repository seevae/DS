public interface SLInterface<E> {
    //是否为空
    boolean isEmpty(SeqList<E> SL);
    //初始化
    void SListInit(SeqList<E> SL,int cap);
    //销魂
    void SListDestroy(SeqList<E> SL);
    //头插
    void SListPushFront(SeqList<E> SL,Object data);
    //头删
    void SListPopFront();
    //尾插
    void SListPushTail();
    //尾删
    void SListPopTail();
    //在pos所在的下标做数据插入
    void SListInsert();
    //删除pos所在下标的数据
    void SListPop();

    // 找从 0 开始的第一个，如果找到了，返回数据所在的下标
    // 如果没找到返回 -1
    int SeqListFind();

    // 删除第一个遇到的 data
    void SeqListRemove();

    // 删除所有遇到的 data
    void SeqListRemoveAll();

    // 修改，pos 所在的下标
    void SeqListModify();

    // 打印
    void SeqListPrint(SeqList<E> SL);

    // 内部接口
    void CheckCapacity();

    // 冒泡排序
    void SeqListBubbleSort();

    // 二分查找（前提是数据有序）
    // 如果找到，返回数据所在下标，如果没找到，返回 -1
    int SeqListBinarySearch();
}
