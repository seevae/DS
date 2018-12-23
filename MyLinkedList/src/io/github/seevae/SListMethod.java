package io.github.seevae;
/*
    name zhang;
    */

public interface SListMethod<E> {


    //初始化和销毁
    void InitSeqList();

    void DestroySeqList(SList<E> sList);

    //尾插/头插
    void PushBackSeqList(E data);

    // void PushBackSeqList(SList<E> sList,E data);
    void PushFrontSeqList(E data);

    //头删/头插
    void PopBackSeqList();

    void PopFrontSeqList();

    //在指定节点位置插入
    void InsertSeqList(int pos,E data);

    //删除pos这个节点
    void EraseSeqList(E data);

    //查找
    //从第一个开始查找如果找到了返回第一次出现位置的索引,如果没有找到则返回-1
    SList<E>.Node FindSeqList(E data);

    //删除遇到的第一个data
    void RemoveSeqList(E data);

    //打印
    void PrintSeqList(SList<E> sList);
}
