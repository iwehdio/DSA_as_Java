package Sequence.List.Node;

public class DL_Node<T> implements Position<T> {

    private T element;      //存储的数据内容
    private DL_Node<T> prev;    //指向上一个节点
    private DL_Node<T> next;   //指向下一个节点

    public DL_Node(){
        this(null, null, null);
    }
    public DL_Node(T e, DL_Node<T> p, DL_Node<T> n){
        this.element = e;
        this.prev = p;
        this.next = n;
    }

    @Override
    public T getElem() {
        return element;
    }

    @Override
    public T setElem(T e) {
        T ori_element = element;
        element = e;
        return ori_element;
    }

    //双链表节点方法
    public void setNext(DL_Node<T> newNext) {
        next = newNext;
    }

    public void setPrev(DL_Node<T> newPrev) {
        prev = newPrev;
    }

    public DL_Node<T> getNext() {
        return next;
    }

    public DL_Node<T> getPrev() {
        return prev;
    }
}
