public class Test {

    public static void main(String[] args){
        SeqList<Integer> seqList = new SeqList<>();
        seqList.SListInit(seqList,10);
        seqList.isEmpty(seqList);
        //seqList.SListDestroy(seqList);
        seqList.SListPushFront(seqList,1);
        seqList.SListPushFront(seqList,2);
        seqList.SListPushFront(seqList,3);
        seqList.SListPushFront(seqList,4);
        seqList.SListPushFront(seqList,5);
        seqList.SeqListPrint(seqList);
    }
}
