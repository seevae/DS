package io.github.seevae;

/**
 * 选择排序
 *
 *  假设数列的第一个值是最小值
 *      从数列的第二个数开始向后找到一个最小的值,和数列第一个值交换,此时数列第一个数就是最小的数
 *
 *   然后从数列的第二个数开始,假设数列第二个数是最小的,从数列第三个数开始,找到一个最小的和第二个数交换...
 *
 *   ...
 */

public class DemoTest {

    public static void selectSort(int arr[]){
        for(int i=0;i<arr.length;i++){
            int min = arr[i];
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
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
