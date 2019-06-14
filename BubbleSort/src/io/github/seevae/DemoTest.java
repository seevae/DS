package io.github.seevae;/*
    name zhang;
    */

public class DemoTest {

    public static void bubbleSort(int arr[]){
        //外层是比较的次数
        int flag = 1;
        for(int i=0;i<arr.length-1;i++){
            //内层是具体的比较和交换
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag=-1;
                }
            }
            if(flag == 1){
                return ;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,9,6,5,7,1,5,3,2,0};
        bubbleSort(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
