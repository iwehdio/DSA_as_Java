package Sequence.List.List;

import Exception.ExceptionBoundaryViolation;
import Exception.ExceptionListEmpty;
import Exception.ExceptionPositionInvalid;
import Iterator.Iterator;
import Iterator.IteratorElement;
import Iterator.IteratorPosition;
import Sequence.List.Node.DL_Node;
import Sequence.List.Node.Node;
import Sequence.List.Node.Position;


public class List_DLNode<T> implements List<T> {

    private int size;
    private DL_Node<T> header;
    private DL_Node<T> trailer;

    public List_DLNode() {
        this.size = 0;
        this.header = new DL_Node<T>(null, null, null);
        this.trailer = new DL_Node<T>(null, this.header, null);
        this.header.setNext(this.trailer);
    }

    public List_DLNode(DL_Node<T> h, int n) {
        this.size = 1;
        this.header = new DL_Node<T>(null, null, null);
        this.trailer = new DL_Node<T>(null, null, null);
        DL_Node<T> newNode = new DL_Node<T>(h.getElem(), this.header, this.trailer);
        this.header.setNext(newNode);
        this.trailer.setPrev(newNode);
        while (--n > 0) {
            newNode = insertAfter(newNode, h.getNext().getElem());
            h = h.getNext();
        }
    }

    //辅助方法，检测传入参数是否合法  flag参数 {"prev","next","both"}
    protected DL_Node<T> checkPosition(Position<T> p, checkFlag flag) throws ExceptionPositionInvalid {
        if(null == p)
            throw new ExceptionPositionInvalid("错误3：传入的位置为空");
        if (checkFlag.PREV.equals(flag) || checkFlag.BOTH.equals(flag)) {
            if(this.header == p)
                throw new ExceptionPositionInvalid("错误4：传入的位置为头哨兵节点");
        }
        if (checkFlag.NEXT.equals(flag) || checkFlag.BOTH.equals(flag)) {
            if(this.trailer == p)
                throw new ExceptionPositionInvalid("错误5：传入的位置为尾哨兵节点");
        }
        return (DL_Node<T>)p;
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
    public DL_Node<T> first() throws ExceptionListEmpty {
        if (isEmpty())
            throw new ExceptionListEmpty("错误10：双链表为空");
        return header.getNext();
    }

    @Override
    public DL_Node<T> last() throws ExceptionListEmpty {
        if (isEmpty())
            throw new ExceptionListEmpty("错误10：双链表为空");
        return trailer.getPrev();
    }

    protected DL_Node<T> prev(Position<T> p, checkFlag flag) throws ExceptionPositionInvalid {
        DL_Node<T> theElem = checkPosition(p, flag);
        return theElem.getPrev();
    }
    protected DL_Node<T> next(Position<T> p, checkFlag flag) throws ExceptionPositionInvalid {
        DL_Node<T> theElem = checkPosition(p, flag);
        return theElem.getNext();
    }

    @Override
    public DL_Node<T> getPrev(Position<T> p) throws ExceptionPositionInvalid, ExceptionBoundaryViolation {
        DL_Node<T> prev = prev(p, checkFlag.BOTH);
        if (prev == header)
            throw new ExceptionBoundaryViolation("错误11：企图越过单链表前端");
        return prev;
    }

    @Override
    public DL_Node<T> getNext(Position<T> p) throws ExceptionPositionInvalid, ExceptionBoundaryViolation {
        DL_Node<T> next = next(p, checkFlag.BOTH);
        if (next == this.trailer)
            throw new ExceptionBoundaryViolation("错误12：企图越过单链表后端");
        return next;
    }

    protected DL_Node<T> getPrevIn(Position<T> p) throws ExceptionPositionInvalid {
        return prev(p, checkFlag.PREV);
    }

    protected DL_Node<T> getNextIn(Position<T> p) throws ExceptionPositionInvalid {
        return next(p, checkFlag.NEXT);
    }

    @Override
    public DL_Node<T> insertFirst(T e) {
        DL_Node<T> newNode = new DL_Node<T>(e, header, header.getNext());
        header.getNext().setPrev(newNode);
        header.setNext(newNode);
        size++;
        return newNode;
    }

    @Override
    public DL_Node<T> insertLast(T e) {
        DL_Node<T> newNode = new DL_Node<T>(e, trailer.getPrev(), trailer);
        trailer.getPrev().setNext(newNode);
        trailer.setPrev(newNode);
        size++;
        return newNode;
    }

    @Override
    public DL_Node<T> insertBefore(Position<T> p, T e) throws ExceptionPositionInvalid {
        DL_Node<T> theElem = checkPosition(p, checkFlag.BOTH);
        DL_Node<T> newNode = new DL_Node<T>(e, theElem.getPrev(), theElem);
        theElem.getPrev().setNext(newNode);
        theElem.setPrev(newNode);
        size++;
        return newNode;
    }

    @Override
    public DL_Node<T> insertAfter(Position<T> p, T e) throws ExceptionPositionInvalid {
        DL_Node<T> theElem = checkPosition(p, checkFlag.BOTH);
        DL_Node<T> newNode = new DL_Node<T>(e, theElem, theElem.getNext());
        theElem.getNext().setPrev(newNode);
        theElem.setNext(newNode);
        size++;
        return newNode;
    }

    @Override
    public T remove(Position<T> p) throws ExceptionPositionInvalid {
        DL_Node<T> theElem = checkPosition(p, checkFlag.BOTH);
        DL_Node<T> prevNode = getPrevIn(theElem);
        theElem.getNext().setPrev(prevNode);
        prevNode.setNext(theElem.getNext());
        T elem = theElem.getElem();
        //将该位置（节点）从列表中摘出，以便系统回收其占用的空间
        theElem.setPrev(null);
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
        return remove(trailer.getPrev());
    }

    @Override
    public T replace(Position<T> p, T e) throws ExceptionPositionInvalid {
        DL_Node<T> theElem = checkPosition(p, checkFlag.BOTH);
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
        if (size == 0) System.out.println("双链表为空");
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

    //循秩访问
    public DL_Node<T> getAtRank(int Rank) {
        if (Rank < 0 || Rank >= size)
            throw new ExceptionBoundaryViolation("错误13：传入的秩越界");
        DL_Node<T> node = first();
        while (Rank-- > 0) {
            node = node.getNext();
        }
        return node;
    }

    //查找
    public DL_Node<T> find(T e, int n, Position<T> p) throws ExceptionPositionInvalid,NullPointerException {
        if (e == null)
            throw new NullPointerException("错误14：传入的数值为空");
        DL_Node<T> node = checkPosition(p, checkFlag.BOTH).getPrev();      //注意，接口定义是前n个真前驱（不包括）
        while (n-- > 0) {
            if (e.equals(node.getElem())) {     //防止空指针异常
                return node;
            }
            node = node.getPrev();
        }
        return null;
    }

    //去重
    public int uniquify()  throws ExceptionPositionInvalid, NullPointerException {
        if (size < 2) return 0;
        DL_Node<T> node = first();
        int prevNum = 0;
        int removeNum = 0;
        while (node != trailer) {
            DL_Node<T> temp = find(node.getElem(),prevNum, node);
            if ((temp != null)) {       //删除前驱中的雷同项比较方便，否则处理指向比较复杂
                remove(temp);
                removeNum++;
            } else {
                prevNum++;
            }
            node = node.getNext();
        }
        return removeNum;
    }

}


