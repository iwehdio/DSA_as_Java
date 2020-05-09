package Test.AsList;

import Iterator.Iterator;
import Sequence.List.List.List;
import Sequence.List.List.List_SLNode;
import Sequence.List.Node.Position;

import java.util.Random;

public class SLList_Test {
    public static void main(String[] args) {

        List<Integer> list = new List_SLNode<Integer>();
        Random random = new Random();

        if (list.isEmpty()) {
            System.out.println("单链表为空");
        }
        System.out.println("初始化单链表：");
        int num = 20;
        for (int i=0; i<num; i++) {
            list.insertLast(random.nextInt(100));
        }
        list.show();

        //元素迭代器只能遍历并取出元素
        System.out.println("元素迭代器遍历单链表");
        Iterator<Integer> elements = list.elements();
        while (elements.hasNext()) {
            System.out.print(elements.getNext() + " ");
        }
        System.out.println();

        //位置迭代器可以修改元素
        System.out.println("位置迭代器遍历并修改单链表内容为原来的三倍：");
        Iterator<Integer> positions1 = list.positions();
        while (positions1.hasNext()) {
            Position<Integer> position = (Position<Integer>) positions1.getNext();
            position.setElem(position.getElem() * 3);
        }
        list.show();

        System.out.println("在单链表首尾插入0");
        list.insertFirst(0);
        list.insertLast(0);
        list.show();

        System.out.println("在单链表首后尾前插入-5");
        list.insertAfter(list.first(), -5);
        list.insertBefore(list.last(), -5);
        list.show();

        System.out.println("位置迭代器遍历单链表，将大于200的元素置为200，小于0的元素删除：");
        Iterator<Integer> positions2 = list.positions();
        while (positions2.hasNext()) {
            Position<Integer> position = (Position<Integer>) positions2.getNext();
            if (position.getElem() > 200) {
                list.replace(position, 200);
            }
            if (position.getElem() < 0) {
                list.remove(position);
            }
        }
        System.out.println("还剩" + list.getSize() + "个元素");
        list.show();
    }
}
