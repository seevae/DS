package io.github.seevae;

/**
 * 选择排序
 *
 */

public class DemoTest {

    public static void selectSort(int arr[]){
        //外层循环代表总共执行的次数
        for(int i=0;i<arr.length;i++){
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            int tmp= arr[min];
            arr[min] = arr[i];
            arr[i] = tmp;
        }
    }

    public static void main(String[] args) {
        int arr[] = {7,9,5,4,2,1,3,0,10,8,6};
        selectSort(arr);
        for(int i: arr){
            System.out.print(i+" ");
        }
    }
}
