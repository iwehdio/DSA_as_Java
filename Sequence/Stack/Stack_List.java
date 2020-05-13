package Sequence.Stack;

import Exception.ExceptionStackEmpty;
import Exception.ExceptionStackFull;
import Sequence.List.Node.Node;

public class Stack_List<T> implements Stack<T> {

    private Node<T> top;
    private int size;

    public Stack_List() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size==0);
    }

    @Override
    public T top() throws ExceptionStackEmpty {
        if(isEmpty())
            throw new ExceptionStackEmpty("错误16：栈为空。");
        else {
            return top.getElem();
        }
    }

    @Override
    public void push(T ele) {
        Node<T> v = new Node<>(ele, top);
        size++;
        top = v;
    }

    @Override
    public T pop() throws ExceptionStackEmpty {
        if(isEmpty())
            throw new ExceptionStackEmpty("错误16：栈为空。");
        else {
            T ele = top.getElem();
            top = top.getNext();
            size--;
            return ele;
        }
    }
}
