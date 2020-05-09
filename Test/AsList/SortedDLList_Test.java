package Test.AsList;

import Iterator.Iterator;
import Sequence.List.List.List_DLNode;
import Sequence.List.List.List_SortedDLNode;
import Sequence.List.Node.DL_Node;
import Sequence.List.Node.Position;
import Sequence.Sorter.Sorter_Insertsort;
import Sequence.Sorter.Sorter_Selectsort;

import java.util.Random;

public class SortedDLList_Test {
    public static void main(String[] args) {

        List_SortedDLNode<Integer> list1 = new List_SortedDLNode<Integer>();
        Random random = new Random();

        System.out.println("初始化有序双链表：");
        int num = 20;
        for (int i=0; i<num; i++) {
            list1.insertLast(random.nextInt(100));
        }
        list1.show();

        System.out.println("在首节点后插元素50");
        list1.insertAfter(list1.first(), 50);
        list1.show();

        System.out.println("选择排序：");
        Sorter_Selectsort<Integer> selectsort = new Sorter_Selectsort<Integer>();
        selectsort.sort(list1);
        list1.show();

        System.out.println("去重");
        int removeNum = list1.uniquify();
        System.out.println("共删除了" + removeNum + "个重复元素");
        list1.show();

        System.out.println("查找元素50并删除：");       //对于最后一个元素要单独判断，因为接口定义的是判断真前驱（不包括），而且无法传入尾哨兵
        DL_Node<Integer> node = list1.search(50, list1.getSize()-1, list1.last());
        list1.remove(node);
        list1.show();


        List_SortedDLNode<Integer> list2 = new List_SortedDLNode<Integer>();

        System.out.println("初始化有序双链表：");
        for (int i=0; i<num; i++) {
            list2.insertLast(random.nextInt(100));
        }
        list2.show();

        System.out.println("插入排序：");
        Sorter_Insertsort<Integer> insertsort = new Sorter_Insertsort<Integer>();
        selectsort.sort(list2);
        list2.show();

    }
}
