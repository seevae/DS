public class Test {

    //基本功能的测试
    public static void code1(){
        SeqList<Integer> seqList = new SeqList<>();
        seqList.SListInit(seqList,10);
        seqList.isEmpty(seqList);
        seqList.SListDestroy(seqList);
        seqList.SListPushFront(seqList,2);
        seqList.SListPushFront(seqList,3);
        seqList.SListPushFront(seqList,3);
        seqList.SListPushFront(seqList,4);
        seqList.SListPushFront(seqList,5);
        seqList.SListPushFront(seqList,1);
        seqList.SListInsert(seqList,1,5);
        seqList.SListErase(seqList,1);
        seqList.SeqListPrint(seqList);
         seqList.SeqListFind(seqList,5);
        seqList.SeqListRemove(seqList,3);
         seqList.SeqListRemoveAll(seqList,3);
        seqList.SeqListModify(seqList,1,8);
        seqList.SeqListBubbleSort(seqList);
        int result = seqList.SeqListBinarySearch(seqList,4);
        if(result == -1){
            System.out.println("没有找到所查元素");
        }else{
            System.out.println("所查元素下标为: "+result);
        }
        seqList.SeqListPrint(seqList);

    }

    //自动扩容的测试
    public static void code2(){
        SeqList<Integer> seqList = new SeqList<>();
        seqList.SListInit(seqList,10);
        seqList.SListPushFront(seqList,1);
        seqList.SListPushFront(seqList,2);
        seqList.SListPushFront(seqList,3);
        seqList.SListPushFront(seqList,4);
        seqList.SListPushFront(seqList,5);
        seqList.SListPushFront(seqList,6);
        seqList.SListPushFront(seqList,7);
        seqList.SListPushFront(seqList,8);
        seqList.SListPushFront(seqList,9);
        seqList.SListPushFront(seqList,10);
        seqList.SListPushFront(seqList,11);
        seqList.SeqListPrint(seqList);
    }

    public static void main(String[] args){
        code1();
    }
}
