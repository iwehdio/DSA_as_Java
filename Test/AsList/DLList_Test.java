package Test.AsList;

import Iterator.Iterator;
import Sequence.List.List.List;
import Sequence.List.List.List_DLNode;
import Sequence.List.Node.DL_Node;
import Sequence.List.Node.Position;
import Sequence.Sorter.Sorter_Selectsort;

import java.util.Random;

public class DLList_Test {
    public static void main(String[] args) {

        List_DLNode<Integer> list = new List_DLNode<Integer>();
        Random random = new Random();

        if (list.isEmpty()) {
            System.out.println("双链表为空");
        }
        System.out.println("初始化双链表：");
        int num = 20;
        for (int i=0; i<num; i++) {
            list.insertLast(random.nextInt(100));
        }
        list.show();

        //元素迭代器只能遍历并取出元素
        System.out.println("元素迭代器遍历双链表");
        Iterator<Integer> elements = list.elements();
        while (elements.hasNext()) {
            System.out.print(elements.getNext() + " ");
        }
        System.out.println();

        //位置迭代器可以修改元素
        System.out.println("位置迭代器遍历并修改双链表内容为原来的三倍：");
        Iterator<Integer> positions1 = list.positions();
        while (positions1.hasNext()) {
            Position<Integer> position = (Position<Integer>) positions1.getNext();
            position.setElem(position.getElem() * 3);
        }
        list.show();

        System.out.println("在双链表首尾插入0");
        list.insertFirst(0);
        list.insertLast(0);
        list.show();

        System.out.println("在双链表首后尾前插入-5");
        list.insertAfter(list.first(), -5);
        list.insertBefore(list.last(), -5);
        list.show();

        System.out.println("位置迭代器遍历双链表，将大于200的元素置为200，小于0的元素删除：");
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

        System.out.println("基于复制的构造：");
        System.out.println("完全复制：");
        List_DLNode<Integer> list2 = new List_DLNode<Integer>((DL_Node<Integer>)list.first(), list.getSize());
        list2.show();
        System.out.println("复制前10个元素：");
        List_DLNode<Integer> list3 = new List_DLNode<Integer>((DL_Node<Integer>)list.first(), 10);
        list3.show();

        System.out.println("获取秩为7的元素：");
        System.out.println(list.getAtRank(7).getElem());
        System.out.println("在其后插入-10");
        list.insertAfter(list.getAtRank(7), -10);
        list.show();

        System.out.println("在整个双链表中查找为-10的元素：");
        DL_Node<Integer> node = list.find(-10, list.getSize(), list.last());
        if (node != null)
            System.out.println("值为" + node.getElem() + "的元素的前驱和后继分别为" + node.getPrev().getElem() + "和" + node.getNext().getElem());

        System.out.println("去重");
        int removeNum = list.uniquify();
        System.out.println("共删除了" + removeNum + "个重复元素");
        list.show();

        System.out.println("选择排序：");
        Sorter_Selectsort<Integer> selectsort = new Sorter_Selectsort<Integer>();
        selectsort.sort(list);
        list.show();
    }
}
