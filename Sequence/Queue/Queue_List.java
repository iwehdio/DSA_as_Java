package Sequence.Queue;

import Exception.ExceptionQueueEmpty;
import Sequence.List.Node.Node;

public class Queue_List<T> implements Queue<T> {

    protected Node<T> header;
    protected Node<T> trailer;
    protected int size;

    public Queue_List() {
        size = 0;
        header = null;
        trailer = null;
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
    public T front() throws ExceptionQueueEmpty {
        if(isEmpty())
            throw new ExceptionQueueEmpty("错误18：队列为空");
        return trailer.getElem();
    }

    @Override
    public void enqueue(T obj) {
        Node<T> node = new Node<T>();
        node.setElem(obj);
        node.setNext(null);
        if(size == 0 ) header = node;
        else trailer.setNext(node);
        trailer = node;
        size++;
    }

    @Override
    public T dequeue() throws ExceptionQueueEmpty {
        if(isEmpty())
            throw new ExceptionQueueEmpty("错误18：队列为空");
        T elem = header.getElem();
        header = header.getNext();
        size--;
        if(size == 0) trailer = null;
        return elem;
    }

    @Override
    public void Traversal() {
        Node<T> p = header;
        while (p != null) {
            System.out.print(p.getElem() + " ");
            p = p.getNext();
        }
        System.out.println();
    }
}
