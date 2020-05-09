package Sequence.List.List;

import Exception.ExceptionPositionInvalid;
import Exception.ExceptionListNotSorted;
import Sequence.Comparator.ComparatorDefault;
import Sequence.List.Node.DL_Node;
import Sequence.List.Node.Position;

public class List_SortedDLNode<T extends Comparable> extends List_DLNode<T> {

    public boolean isSorted() {
        DL_Node<T> head = super.first();
        while (!head.equals(super.last())) {
            if (head.getElem().compareTo(head.getNext().getElem()) == 1) {
                return false;
            }
            head = head.getNext();
        }
        return true;
    }

    public DL_Node<T> search(T e, int n, DL_Node<T> p) throws ExceptionPositionInvalid,NullPointerException {
        if (e == null)
            throw new NullPointerException("错误14：传入的数值为空");
        DL_Node<T> node = checkPosition(p, checkFlag.BOTH).getPrev();      //注意，接口定义是前n个真前驱（不包括）
        DL_Node<T> res = new DL_Node<T>();
        while (n-- > 0) {
            if (e.compareTo(node.getElem()) < 0) {     //防止空指针异常
                res = node;
            }
            node = node.getPrev();
        }
        return res.getPrev();
    }

    @Override
    public int uniquify() throws ExceptionListNotSorted, ExceptionPositionInvalid, NullPointerException {
        if (!isSorted())
            throw new ExceptionListNotSorted("错误15：列表不是有序的，不能直接调用有序列表的方法");
        if (getSize() < 2) return 0;
        int removeNum = 0;
        DL_Node<T> p = first();
        DL_Node<T> q = p.getNext();
        while (!super.last().equals(q)) {
            if (!p.getElem().equals(q.getElem())) {
                p = q;
            } else {
                remove(q);
                removeNum++;
            }
            q = p.getNext();
        }
        return removeNum;
    }
}
