package Sequence.Queue;

import Exception.ExceptionQueueEmpty;
import Exception.ExceptionQueueFull;

public interface Queue<T> {
    //取得队列规模
    public int getSize();
    //判空
    public boolean isEmpty();
    //取得队首元素
    public T front()
            throws ExceptionQueueEmpty;
    //入队
    public void enqueue (T obj)
            throws ExceptionQueueFull;
    //出队
    public T dequeue()
            throws ExceptionQueueEmpty;
    //遍历
    public void Traversal();
}
