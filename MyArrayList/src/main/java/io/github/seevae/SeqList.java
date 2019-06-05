package io.github.seevae;/*
    name zhang;
    */

import java.lang.reflect.Array;

public class SeqList<E> implements IArrayList{
    private Object[] array;
    //顺序表的容量
    private int capacity;
    //顺序表的实际长度
    private int length;

    public boolean isEmpty(SeqList SL) {
        if(SL==null){
            System.out.println("静态顺序表未创建");
            return false;
        }

        if(SL.length == 0){
            System.out.println("静态顺序表初始化容量为零");
        }
        System.out.println("静态顺序表不为空");
        return true;
    }

    public void SListInit(SeqList SL, int cap) {
        this.capacity = cap;
        SL.array = new Object[capacity];
        this.length =0;
    }

    public void SListDestroy(SeqList SL) {
        SL.array = null;
        SL.capacity=SL.length=0;
    }

    public int SListLength(SeqList SL) {
        return SL.length;
    }

    public void SListPushFront(SeqList SL, Object data) {
        CheckCapacity(SL);
        try{
            //当数组为空时
            if(SL.length == 0){
                SL.array[0] = data;
                SL.length++;
            }else{
                //这里i的值是数组下标
                for(int i=SL.length-1;i>=0;i--){
                    SL.array[i+1] = SL.array[i];
                }
                SL.array[0] = data;
                SL.length++;
            }
        }catch (Exception e){
            throw new NullPointerException();
        }

    }

    public void SListPopFront(SeqList SL) {
        try{
            if(SL.length <= 0){
                System.out.println("已经没有可删除的元素了");
                return;
            }
            for(int i=0;i<SL.length-1;i++){
                SL.array[i] = SL.array[i+1];
            }
            SL.length--;
        }catch (Exception e){
            throw new NullPointerException();
        }
    }

    public void SListPushTail(SeqList SL, Object data) {
        CheckCapacity(SL);
        try{
            SL.array[SL.length] = data;
            SL.length++;
        }catch (Exception e){
            throw new NullPointerException();
        }
    }

    public void SListPopTail(SeqList SL) {
        try{
            SL.length--;
            if(SL.length<=0){
                System.out.println("没有可以删除的元素了");
            }
        }catch (Exception e){
            throw new NullPointerException();
        }
    }

    //指定下标处插入
    public void SListInsert(SeqList SL, int pos, Object data) {
        CheckCapacity(SL);
        try{
            //先进行插入位置合法化的判断
            if(pos<0 || pos>SL.length-1){
                System.out.println("非法插入");
                return;
            }

            for(int i=SL.length;i>pos;i--){
                SL.array[i] = SL.array[i-1];
            }
            SL.array[pos] = data;
            SL.length++;
        }catch (Exception e){
            throw new NullPointerException();
        }
    }

    public void SListErase(SeqList SL, int pos) {
        if(pos < 0 ||pos>SL.length-1){
               return;
        }

        for(int i=pos;i<SL.length;i++){
            SL.array[i] = SL.array[i+1];
        }
        SL.length--;
    }

    public int SeqListFind(SeqList SL, Object data) {
        try{
            for(int i=0;i<SL.length;i++){
                if(SL.array[i].equals(data)){
                    return i;
                }
            }
        }catch (Exception e){
            throw new NullPointerException();
        }
        return -1;
    }

    public void SeqListRemove(SeqList SL, Object data) {
        try{
            int delIndex = this.SeqListFind(SL,data);
            SListErase(SL,delIndex);
        }catch (Exception e){
            throw new NullPointerException();
        }
    }

    public void SeqListRemoveAll(SeqList SL, Object data) {
        for(int i=0;i<SL.length;i++){

            if(SL.array[i]==data&&SL.array[i].equals(data)){
                for(int j=i;j<SL.length;j++){
                    SL.array[j] = SL.array[j+1];
                }
                SL.length--;
                i--;
            }

        }
    }

    public void SeqListModify(SeqList SL, int pos, Object data) {
        try{
            if(pos<0 || pos>SL.length-1){
                return;
            }
            SL.array[pos] = data;
        }catch (Exception e){
            throw new NullPointerException();
        }
    }

    public void SeqListPrint(SeqList SL) {
        for(int i = 0; i<SL.length; i++){
            System.out.print(SL.array[i]+" ");
        }
        System.out.println();
    }

    public void CheckCapacity(SeqList SL) {
        if(SL.capacity>SL.length){
            return;
        }else{
            //扩容
            int newCapacity = SL.capacity*2;
            Object[] newArr =new Object[newCapacity];
            for(int i=0;i<SL.length;i++){
                newArr[i] = SL.array[i];
            }
            SL.array = newArr;
            SL.capacity = newCapacity;
            newArr = null;
        }
    }

    public void SeqListBubbleSort(SeqList SL) {
        try{

            for(int j=0;j<SL.length;j++){
                int flag = -1;
                for(int i=0;i<SL.length-1-j;i++){
                    if((Integer)SL.array[i]>(Integer)SL.array[i+1]){
                        Integer tmp = (Integer) SL.array[i];
                        SL.array[i] = SL.array[i+1];
                        SL.array[i+1] = tmp;
                        flag = 1;
                    }
                }
                if(flag == -1){
                    return;
                }
            }
        }catch (Exception e){
            throw new NullPointerException();
        }
    }

    public int SeqListBinarySearch(SeqList SL, Object data) {
        try{
            int left = 0;
            int right = SL.length;
            while(true){

                int mid = (left-right)/2+right;

                if(SL.array[mid] == data && SL.array[mid].equals(data)){
                    return mid;
                }

                if((Integer)SL.array[mid] < (Integer) data){
                    left =mid+1;
                }

                if((Integer)SL.array[mid] > (Integer)data){
                    right = mid-1;
                }

            }

        }catch (Exception e){
            throw new NullPointerException();
        }
    }
}
