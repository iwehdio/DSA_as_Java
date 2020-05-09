package Sequence.List.Node;

public class Node<T> implements Position<T> {

    private T element;      //存储的数据内容
    private Node<T> next;   //指向下一个节点

    public Node(){
        this(null, null);
    }
    public Node(T e, Node<T> n){
        this.element = e;
        this.next = n;
    }

    @Override
    public T getElem() {
        return this.element;
    }

    @Override
    public T setElem(T e) {
        T ori_element = this.element;
        this.element = e;
        return ori_element;
    }

    //单链表节点方法
    public void setNext(Node<T> newNext) {
        this.next = newNext;
    }

    public Node<T> getNext() {
        return next;
    }
}
