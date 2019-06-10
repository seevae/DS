package io.github.seevae;/*
    name zhang;
    */

public class Test {
    public static void main(String[] args) {
        HeadSingleListC headSingleListC = new HeadSingleListC();
        headSingleListC.addFirst(1);
        headSingleListC.addFirst(2);
        headSingleListC.addFirst(3);

        headSingleListC.addLast(1);
        headSingleListC.addLast(2);
        headSingleListC.addLast(3);

        System.out.println(headSingleListC.getLength());

        headSingleListC.addIndex(2,6);

       int result = headSingleListC.remove(3);
       headSingleListC.removeAllKey(2);

       headSingleListC.display();
    }
}
