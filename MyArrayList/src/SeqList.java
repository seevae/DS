public  class SeqList<E> implements SLInterface<E> {
    private Object[] array;
    //线性表容量
    private int capacity;
    //实际所用大小
    private int length;

    @Override
    public boolean isEmpty(SeqList<E> SL) {
        if(SL.array == null){
            System.out.println("静态顺序表未创建");
            return false;
        }

        if(SL.capacity == 0){
         System.out.println("静态顺序表容量初始化为0");
        }

        System.out.println("顺序表不为空");
        return true;
    }

    @Override
    public void SListInit(SeqList<E> SL,int cap) {
        SL.array = new Object[cap];
        this.capacity = cap;
        this.length = 0;
    }

    @Override
    public void SListDestroy(SeqList<E> SL) {
        SL.array =null;
        SL.length = SL.capacity = 0;
    }

    @Override
    public void SListPushFront(SeqList<E> SL,Object data) {
        try{
            for(int i=SL.length; i>=1; i--){
                SL.array[i] = SL.array[i-1];
            }
            SL.array[0] = data;
            SL.length++;
        }catch(Exception E){
            throw new NullPointerException();
        }
    }

    @Override
    public void SListPopFront() {

    }

    @Override
    public void SListPushTail() {

    }

    @Override
    public void SListPopTail() {

    }

    @Override
    public void SListInsert() {

    }

    @Override
    public void SListPop() {

    }

    @Override
    public int SeqListFind() {
        return 0;
    }

    @Override
    public void SeqListRemove() {

    }

    @Override
    public void SeqListRemoveAll() {

    }

    @Override
    public void SeqListModify() {

    }

    @Override
    public void SeqListPrint(SeqList<E> SL) {
       for(int i=0; i<SL.length; i++){
           System.out.print(SL.array[i]+" ");
       }

       System.out.println();
    }

    @Override
    public void CheckCapacity() {

    }

    @Override
    public void SeqListBubbleSort() {

    }

    @Override
    public int SeqListBinarySearch() {
        return 0;
    }
}
