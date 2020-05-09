package Sequence.List.List;

import Sequence.List.Node.Node;
import Sequence.List.Node.Position;
import Exception.ExceptionPositionInvalid;
import Exception.ExceptionBoundaryViolation;
import Exception.ExceptionListEmpty;
import Iterator.Iterator;
import Iterator.IteratorElement;
import Iterator.IteratorPosition;

enum checkFlag {
    PREV, NEXT, BOTH
}

public class List_SLNode<T> implements List<T> {

    private int size;
    private Node<T> header;
    private Node<T> trailer;

    public List_SLNode() {
        this.size = 0;
        this.header = new Node<T>(null, null);
        this.trailer = new Node<T>(null, null);
        this.header.setNext(this.trailer);
    }

    //辅助方法，检测传入参数是否合法  flag参数 {"prev","next","both"}
    protected Node<T> checkPosition(Position<T> p, checkFlag flag) throws ExceptionPositionInvalid {
        if(null == p)
            throw new ExceptionPositionInvalid("错误3：传入的位置为空");
        if (checkFlag.PREV.equals(flag) || checkFlag.BOTH.equals(flag)) {
            if(header == p)
                throw new ExceptionPositionInvalid("错误4：传入的位置为头哨兵节点");
        }
        if (checkFlag.NEXT.equals(flag) || checkFlag.BOTH.equals(flag)) {
            if(trailer == p)
                throw new ExceptionPositionInvalid("错误5：传入的位置为尾哨兵节点");
        }
        return (Node<T>)p;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public Node<T> first() throws ExceptionListEmpty {
        if (isEmpty())
            throw new ExceptionListEmpty("错误6：单链表为空");
        return header.getNext();
    }

    @Override
    public Node<T> last() throws ExceptionListEmpty {
        if (isEmpty())
            throw new ExceptionListEmpty("错误6：单链表为空");
        Node<T> temp = header;
        while (!temp.getNext().equals(trailer))
            temp = temp.getNext();
        return temp;
    }

    protected Node<T> prev(Position<T> p, checkFlag flag) throws ExceptionPositionInvalid {
        Node<T> theElem = checkPosition(p, flag);
        Node<T> prev = header;
        while (!prev.getNext().equals(theElem))
            prev = prev.getNext();
        return prev;
    }
    protected Node<T> next(Position<T> p, checkFlag flag) throws ExceptionPositionInvalid {
        Node<T> theElem = checkPosition(p, flag);
        return theElem.getNext();
    }

    @Override
    public Node<T> getPrev(Position<T> p) throws ExceptionPositionInvalid, ExceptionBoundaryViolation {
        Node<T> prev = prev(p, checkFlag.BOTH);
        if (prev == header)
            throw new ExceptionBoundaryViolation("错误7：企图越过单链表前端");
        return prev;
    }

    @Override
    public Node<T> getNext(Position<T> p) throws ExceptionPositionInvalid, ExceptionBoundaryViolation {
        Node<T> next = next(p, checkFlag.BOTH);
        if (next == trailer)
            throw new ExceptionBoundaryViolation("错误8：企图越过单链表后端");
        return next;
    }

    /*
    因为单链表的getPrev()和getNext()方法不能返回头尾哨兵，
    所以不能直接调用insertBefore()和insertAfter()方法而要单独实现.
    实现可以返回哨兵的内部方法
    */
    protected Node<T> getPrevIn(Position<T> p) throws ExceptionPositionInvalid {
        return prev(p, checkFlag.PREV);
    }

    protected Node<T> getNextIn(Position<T> p) throws ExceptionPositionInvalid {
        return next(p, checkFlag.NEXT);
    }


    @Override
    public Node<T> insertFirst(T e) {
        Node<T> newNode = new Node<T>(e, header.getNext());
        header.setNext(newNode);
        size++;
        return newNode;
    }

    @Override
    public Node<T> insertLast(T e) {
        Node<T> newNode = new Node<T>(e, trailer);
        Node<T> prev = getPrevIn(trailer);            //这样返回末节点的效率很低，另一种方法是单独存储末节点
        prev.setNext(newNode);
        size++;
        return newNode;
    }

    @Override
    public Node<T> insertBefore(Position<T> p, T e) throws ExceptionPositionInvalid {
        Node<T> theElem = checkPosition(p, checkFlag.BOTH);
        Node<T> newNode = new Node<T>(e, theElem);
        Node<T> prev = getPrev(theElem);
        prev.setNext(newNode);
        size++;
        return newNode;
    }

    @Override
    public Node<T> insertAfter(Position<T> p, T e) throws ExceptionPositionInvalid {
        Node<T> theElem = checkPosition(p, checkFlag.BOTH);
        Node<T> newNode = new Node<T>(e, theElem.getNext());
        theElem.setNext(newNode);
        size++;
        return newNode;
    }

    @Override
    public T remove(Position<T> p) throws ExceptionPositionInvalid {
        Node<T> theElem = checkPosition(p, checkFlag.BOTH);
        Node<T> prevNode = getPrevIn(theElem);
        prevNode.setNext(theElem.getNext());
        T elem = theElem.getElem();
        //将该位置（节点）从列表中摘出，以便系统回收其占用的空间
        theElem.setNext(null);
        size--;
        return elem;
    }

    @Override
    public T removeFirst() {
        return remove(header.getNext());
    }

    @Override
    public T removeLast() {
        return remove(getPrev(trailer));
    }

    @Override
    public T replace(Position<T> p, T e) throws ExceptionPositionInvalid {
        Node<T> theElem = checkPosition(p, checkFlag.BOTH);
        T elem = theElem.getElem();
        theElem.setElem(e);
        return elem;
    }

    @Override
    public Iterator<T> positions() {
        return new IteratorPosition<T>(this);
    }

    @Override
    public Iterator<T> elements() {
        return new IteratorElement<T>(this);
    }

    @Override
    public void show() {
        if (size == 0) System.out.println("单链表为空");
        else {
            Position<T> elem = first();
            System.out.print("[");
            while (getNextIn(elem) != trailer) {
                System.out.print(elem.getElem() + ", ");
                elem = getNext(elem);
            }
            System.out.println(elem.getElem() + "]");
        }
    }
}


