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
            CheckCapacity(SL);
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
    public void SListPopFront(SeqList<E> SL) {
           try{
               if(SL.length>0){
                   for(int i=1; i<SL.length; i++){
                       SL.array[i-1] = SL.array[i];
                   }
                   SL.length--;
               }else{
                   System.out.println("顺序表已经为空,不能进行删除操作");
               }
           }catch(Exception e){
               throw new NullPointerException();
           }
    }

    @Override
    public void SListPushTail(SeqList<E> SL,Object data) {
        try{
            CheckCapacity(SL);
            SL.array[SL.length] = data;
            SL.length++;
        }catch(Exception e){
            throw new NullPointerException();
        }
    }

    @Override
    public void SListPopTail(SeqList<E> SL) {
        try{
            SL.length--;
        }catch(Exception e){
            throw new NullPointerException();
        }
    }

    @Override
    public void SListInsert(SeqList<E> SL,int pos, Object data){
        //此处i表示的是元素的位置
        try{
            CheckCapacity(SL);
            if(!(pos>=0 && pos<= SL.length-1)){
                System.out.println("指定插入位置不合法");
                return;
            }
            for(int i=SL.length; i>=pos; i--){
                SL.array[i] = SL.array[i-1];
            }
            SL.array[pos] = data;
            SL.length++;
        }catch(Exception e){
            throw new NullPointerException();
        }
    }

    @Override
    public void SListErase(SeqList<E> SL, int pos) {
        try{
            if(!(pos>=0 && pos<=SL.length)){
                return;
            }
            for(int i=pos; i<SL.length; i++){
                SL.array[i] = SL.array[i+1];
            }
            SL.length--;
        }catch(Exception e){
            throw new NullPointerException();
        }



    }

    @Override
    public int SeqListFind(SeqList<E> SL, Object data) {
        try{
            for(int i=0; i<SL.length; i++){
                if(SL.array[i] == data || SL.array[i].equals(data)){
                    System.out.println("找到了指定的元素: " +data+"他的下标为: "+i);
                    return i;
                }
            }
            System.out.println("没有找到指定元素");
        }catch(Exception e){
            throw new NullPointerException();
        }
        return -1;
    }

    @Override
    public void SeqListRemove(SeqList<E> SL, Object data) {
        try{
            for(int i=0; i<SL.length; i++){
                if(SL.array[i] == data || SL.array[i].equals(data)){
                    for(int j=i; j<SL.length-1; j++){
                        SL.array[j] = SL.array[j+1];
                    }
                }
            }
            SL.length--;
        }catch(Exception e){
            throw new NullPointerException();
        }
    }

    @Override
    public void SeqListRemoveAll(SeqList<E> SL, Object data) {
        try{
            for(int i=0; i<SL.length; i++){
                if(SL.array[i] == data || SL.array[i].equals(data)){
                    for(int j=i; j<SL.length-1; j++){
                        SL.array[j] = SL.array[j+1];
                    }
                    i--;
                    SL.length--;
                }
            }

        }catch(Exception e){
            throw new NullPointerException();
        }
    }

    @Override
    public void SeqListModify(SeqList<E> SL, int pos, Object data) {
        try{
            SL.array[pos] = data;
        }catch(Exception e){
            throw new NullPointerException();
        }

    }

    @Override
    public void SeqListPrint(SeqList<E> SL) {
       for(int i=0; i<SL.length; i++){
           System.out.print(SL.array[i]+" ");
       }

       System.out.println();
    }

    @Override
    public void CheckCapacity(SeqList<E> SL) {
        try{
            if(SL.length < SL.capacity){
                return;
            }
            int newCapacity = SL.capacity*2;
            Object[] newArray = new Object[newCapacity];
            for(int i=0; i<SL.length; i++){
                newArray[i] = SL.array[i];
            }
            SL.array = newArray;
            SL.capacity = newCapacity;
            newArray = null;
        }catch(Exception e){
            throw new NullPointerException();
        }
    }

    @Override
    public void SeqListBubbleSort(SeqList<E> SL) {
        try {
            int i,j;
            for (i = 0; i < SL.length-1; i++){
                int flag = 1;
                for(j=0; j<SL.length-1-i; j++){
                    if((Integer)SL.array[j] > (Integer) SL.array[j+1]){
                        Integer tmp = (Integer) SL.array[j];
                        SL.array[j] =  SL.array[j+1];
                        SL.array[j+1] = tmp;
                        flag = 0;
                    }
                }
                if(flag == 1){
                    break;
                }
            }
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }

    @Override
    // 二分查找的前提是已经排好序的数列
    public int SeqListBinarySearch(SeqList<E> SL, Object data) {
        try{
            int left = 0;
            int right = SL.length-1;
            while(left <= right){
                int mid = (left-right)/2+right;
                if(SL.array[mid] == data){
                    return mid;
                }
                if((Integer)SL.array[mid] > (Integer) data){
                    right = right-mid;
                }

                if((Integer)SL.array[mid] < (Integer) data){
                    left = left+mid;
                }
            }
        }catch(Exception e){
            throw new NullPointerException();
        }
        return -1;
    }
}
