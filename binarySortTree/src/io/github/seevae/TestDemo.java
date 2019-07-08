package io.github.seevae;
/*
    name zhang;
    */

public class TestDemo {

    public static void main(String[] args) {
        BinarySortTree binarySortTree = new BinarySortTree();
        int arr[] = {4,5,7,8,9,6,2,1,3};
        binarySortTree.creatTree(arr);
        binarySortTree.inOrder();
        System.out.println("--------------");
        binarySortTree.firstOrder();
    }
}
