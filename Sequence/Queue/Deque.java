package Sequence.Queue;

import Exception.ExceptionQueueEmpty;

public interface Deque<T> {
    //取得规模
    public int getSize();
    //判空
    public boolean isEmpty();
    //取得首元素
    public T first() throws ExceptionQueueEmpty;
    //取得尾元素
    public T last() throws ExceptionQueueEmpty;
    //插入首元素
    public void insertFirst(T obj);
    //插入尾元素
    public void insertLast(T obj);
    //删除首元素
    public T removeFirst() throws ExceptionQueueEmpty;
    //删除尾元素
    public T removeLast() throws ExceptionQueueEmpty;
    //遍历
    public void Traversal();
}
