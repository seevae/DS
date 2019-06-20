package io.github.seevae;/*
    name zhang;
    */

import java.util.Arrays;

public class Heap implements IHeap {

    private int[] elem;
    private int usedSize;
    private static final int DEFAULT_SIZE =15;

    public Heap(){
        this.elem = new int[DEFAULT_SIZE];
        this.usedSize = 0;
    }


    //堆的初始化,根据建堆的方式不同可以选择建大顶堆或者小顶堆
    //以建大顶堆为例
    public void initHeap(int[] array) {
        for(int i=0;i<array.length;i++){
            this.elem[i] = array[i];
            usedSize++;
        }

        for(int i=(usedSize-1-1)/2;i>=0;i--){
            AdjustDown(i,this.usedSize);
        }

    }

    public void AdjustDown(int root, int len) {
        int parent = root;
        int child = 2*parent+1;

        while(child < len){

            //取两个孩子节点中较大的哪一个
            if(child+1<len &&elem[child]<elem[child+1]){
                child = child+1;
            }

            //父节点和子节点进行比较,并交换
            if(elem[child] > elem[parent]){
                int temp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = temp;
                parent = child;
                child = parent*2+1;
            }else{
                break;
            }
        }

    }

    public void AdjustUp(int num) {
        int child = num;
        int parent = (child-1)/2;
        while(child > 0){
            if(elem[child] > elem[parent]){
                int temp= elem[child];
                elem[child] = elem[parent];
                elem[parent] = temp;
                child = parent;
                parent = (child-1)/2;
            }else{
                break;
            }
        }
    }

    public boolean isFull(){
        return this.usedSize == this.elem.length;
    }

    public void pushHeap(int item) {
        if(isFull()){
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        this.elem[usedSize] = item;
        this.usedSize++;
        AdjustUp(this.usedSize-1);
    }

    public boolean isEmpty(){
        return this.usedSize == 0;
    }

    //返回删除元素
    public int popHeap() {
        if(isEmpty()){
            throw new UnsupportedOperationException("堆为空");
        }
        int oldDate = elem[0];
        int temp = elem[0];
        elem[0] = elem[this.usedSize-1];
        elem[usedSize-1] = temp;
        this.usedSize--;
        AdjustDown(0,this.usedSize);
        return oldDate;
    }

    //得到堆顶元素但不删除
    public int getHeapTop() {
        if(isEmpty()){
            throw new UnsupportedOperationException("堆为空");
        }
        return elem[0];
    }


    /**
     * 时间复杂度: O(nlong2n)
     * 空间复杂度: O(1)
     * 稳定性: 不稳定
     */
    public void HeapSort() {
        int end = this.usedSize-1;
        while(end>0){
            int temp = this.elem[0];
            this.elem[0] = this.elem[end];
            this.elem[end] = temp;
            AdjustDown(0,end);
            end--;
        }
    }

    public void show() {
        for(int i=0;i<usedSize;i++){
            System.out.print(elem[i]+" ");
        }
        System.out.println();
    }

    /**
     * topK问题
     */


}
