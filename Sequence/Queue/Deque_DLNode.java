package Sequence.Queue;

import Exception.ExceptionQueueEmpty;
import Sequence.List.Node.DL_Node;

public class Deque_DLNode<T> implements Deque<T> {

    protected DL_Node<T> header;
    protected DL_Node<T> trailer;
    protected int size;

    public Deque_DLNode() {
        header = new DL_Node<T>();
        trailer = new DL_Node<T>();
        header.setNext(trailer);
        trailer.setPrev(header);
        size = 0;
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
    public T first() throws ExceptionQueueEmpty {
        if(isEmpty())
            throw new ExceptionQueueEmpty("错误20：双端队列为空");
        return header.getNext().getElem();
    }

    @Override
    public T last() throws ExceptionQueueEmpty {
        if(isEmpty())
            throw new ExceptionQueueEmpty("错误20：双端队列为空");
        return trailer.getPrev().getElem();
    }

    @Override
    public void insertFirst(T obj) {
        DL_Node<T> second = header.getNext();
        DL_Node<T> first = new DL_Node<T>(obj, header, second);
        header.setNext(first);
        second.setPrev(first);
        size++;
    }

    @Override
    public void insertLast(T obj) {
        DL_Node<T> second = trailer.getPrev();
        DL_Node<T> first = new DL_Node<T>(obj, second, trailer);
        trailer.setPrev(first);
        second.setNext(first);
        size++;
    }

    @Override
    public T removeFirst() throws ExceptionQueueEmpty {
        if(isEmpty())
            throw new ExceptionQueueEmpty("错误20：双端队列为空");
        DL_Node<T> first = header.getNext();
        T elem = first.getElem();
        header.setNext(first.getNext());
        first.getNext().setPrev(header);
        return elem;
    }

    @Override
    public T removeLast() throws ExceptionQueueEmpty {
        if(isEmpty())
            throw new ExceptionQueueEmpty("错误20：双端队列为空");
        DL_Node<T> first = trailer.getPrev();
        T elem = first.getElem();
        trailer.setPrev(first.getPrev());
        first.getPrev().setNext(trailer);
        return elem;
    }

    @Override
    public void Traversal() {
        DL_Node<T> p = header.getNext();
        while (p != null) {
            System.out.print(p.getElem() + " ");
            p = p.getNext();
        }
        System.out.println();
    }
}
