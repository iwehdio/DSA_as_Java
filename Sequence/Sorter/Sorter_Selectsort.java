package Sequence.Sorter;

import Sequence.Comparator.Comparator;
import Sequence.Comparator.ComparatorDefault;
import Sequence.List.List.List;
import Sequence.List.List.List_DLNode;
import Sequence.List.Node.DL_Node;
import Sequence.List.Node.Position;
import Sequence.Vector.Vector;

public class Sorter_Selectsort<T> implements Sorter<T> {

    private Comparator C;

    public Sorter_Selectsort()
    {  this(new ComparatorDefault()); }

    public Sorter_Selectsort(Comparator comp)
    {  C = comp; }


    @Override
    public void sort(Vector<T> vector) {

    }

    @Override
    public void sort(List<T> list) {
        selectionSort((List_DLNode<T>)list, (DL_Node<T>)list.first(), list.getSize());
    }

    private void selectionSort(List_DLNode<T> list, DL_Node<T> p, int n) {
        DL_Node<T> head = p.getPrev();          //head是头哨兵，注意这里要获取p的前驱，不然删除操作作用于p，会使得p发生变换
        DL_Node<T> tail = p;
        for (int i=0; i<n; i++)
            tail = tail.getNext();
        if (list.last().getNext().equals(tail)) {       //insertBefore无法对尾哨兵操作
            list.insertLast(list.remove(selectMax(head.getNext(), n--)));       //对head的后继操作
            tail = tail.getPrev();
        }
        while (1 < n) {
            list.insertBefore(tail, list.remove(selectMax(head.getNext(), n)));
            tail = tail.getPrev();
            n--;
        }
    }

    private DL_Node<T> selectMax(DL_Node<T> p, int n) {     //起始于p的n个元素（包括p）的最大值
        DL_Node<T> max = p;
        for (DL_Node<T> cur = p; 1<n; n--) {
            cur = cur.getNext();
            if (C.compare(cur.getElem(), max.getElem()) >= 0) {
                max = cur;
            }
        }
        return max;
    }
}
