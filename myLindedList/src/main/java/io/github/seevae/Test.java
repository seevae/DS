package io.github.seevae;/*
    name zhang;
    */

public class Test {
    public static void main(String[] args) {
        MySingleListImpl mySingleList = new MySingleListImpl();
//        mySingleList.addFirst(1);
//        mySingleList.addFirst(2);
//        mySingleList.addFirst(3);

        mySingleList.addLast(1);
        mySingleList.addLast(2);
        mySingleList.addLast(3);
        mySingleList.addLast(4);
        mySingleList.addLast(5);
        mySingleList.addLast(6);
        mySingleList.addLast(7);
        mySingleList.addLast(8);


//
//        mySingleList.addIndex(0,4);
//        mySingleList.addIndex(4,4);
//
//        int length = mySingleList.getLength();
//        System.out.println(length);
//        mySingleList.display();
//
////        mySingleList.remove(4);
////        mySingleList.display();
////        mySingleList.remove(1);
////        mySingleList.display();
//
//        System.out.println(mySingleList.contains(1));
//        mySingleList.display();
//        mySingleList.removeAllKey(4);
//        mySingleList.display();
//
//        //测试内存泄漏,不能让程序一下跑完了
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        MySingleListImpl.Node newHead = mySingleList.reverseList();
//        mySingleList.show(newHead);

//        mySingleList.removeAllKey(2);
//        mySingleList.display();
            mySingleList.midNode();

    }
}
