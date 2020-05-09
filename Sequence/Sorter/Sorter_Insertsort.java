package Sequence.Sorter;

import Sequence.Comparator.Comparator;
import Sequence.Comparator.ComparatorDefault;
import Sequence.List.List.List;
import Sequence.List.List.List_DLNode;

import Sequence.List.Node.DL_Node;
import Sequence.Vector.Vector;
import Exception.ExceptionPositionInvalid;

public class Sorter_Insertsort<T> implements Sorter<T> {

    private Comparator C;

    public Sorter_Insertsort()
    {  this(new ComparatorDefault()); }

    public Sorter_Insertsort(Comparator comp)
    {  C = comp; }


    @Override
    public void sort(Vector<T> vector) {

    }

    @Override
    public void sort(List<T> list) {
        insertionSort((List_DLNode<T>)list, (DL_Node<T>)list.first(), list.getSize());
    }

    private void insertionSort(List_DLNode<T> list, DL_Node<T> p, int n) throws ExceptionPositionInvalid, NullPointerException {

        for (int r=0; r<n; r++) {
            if (p == null || p.getElem() == null)
                throw new NullPointerException("错误14：传入的数值为空");
            if (p.equals(list.first().getPrev()))
                throw new ExceptionPositionInvalid("错误4：传入的位置为头哨兵节点");
            if (p.equals(list.last().getNext()))
                throw new ExceptionPositionInvalid("错误5：传入的位置为尾哨兵节点");
            DL_Node<T> node = p;
            DL_Node<T> res = p;
            int k = r;
            T e = p.getElem();
            while (k-- >= 0) {
                if (C.compare(e, node.getElem()) < 0) {
                    res = node;
                }
                node = node.getPrev();
            }
            res = res.getPrev();
            if (res.equals(list.first().getPrev())) {
                list.insertFirst(e);
            } else {
                list.insertAfter(res, e);
            }
            p = p.getNext();
            list.remove(p.getPrev());
        }
    }

}
