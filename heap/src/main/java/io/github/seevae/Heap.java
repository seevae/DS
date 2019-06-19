package io.github.seevae;/*
    name zhang;
    */

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

    public void AdjustUp(int child, int len) {

    }

    public void pushHeap(int item) {

    }

    public int popHeap() {
        return 0;
    }

    public int getHeapTop() {
        return 0;
    }

    public void HeapSort() {

    }

    public void show() {
        for(int i=0;i<usedSize;i++){
            System.out.print(elem[i]+" ");
        }
        System.out.println();
    }
}
