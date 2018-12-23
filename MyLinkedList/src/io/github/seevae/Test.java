package io.github.seevae;/*
    name zhang;
    */

import javax.swing.plaf.SliderUI;

public class Test {

    public static void code1(){
        SList<Integer> sList = new SList<>();
        sList.InitSeqList();
        sList.PushBackSeqList(3);
        sList.PushBackSeqList(4);
        sList.PushBackSeqList(5);
        sList.PushFrontSeqList(2);
        sList.PushFrontSeqList(1);
        sList.PopBackSeqList();
        sList.PopFrontSeqList();
        sList.InsertSeqList(1,5);
        sList.FindSeqList(3);
        sList.EraseSeqList(3);
        sList.PrintSeqList(sList);
    }

    public static void main(String[] args){
        SList<Integer> sList = new SList<>();
        sList.InitSeqList();
        sList.PushBackSeqList(3);
        sList.PushBackSeqList(4);
        sList.PushBackSeqList(5);
        sList.PushFrontSeqList(2);
        sList.PushFrontSeqList(1);
        sList.PushBackSeqList(3);
        sList.PushBackSeqList(3);
        sList.RemoveSeqList(3);
        sList.PrintSeqList(sList);
    }
}
