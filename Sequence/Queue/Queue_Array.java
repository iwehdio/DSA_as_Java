package Sequence.Queue;

import Exception.ExceptionQueueEmpty;
import Exception.ExceptionQueueFull;

public class Queue_Array<T> implements Queue<T> {

    private final static int defaultSize = 1024;        //默认容量
    protected int realSize;
    protected Object[] Q;
    protected int header;           //指向队首，始终等于首元素的下标
    protected int trailer;          //指向队尾，始终等于末元素的下标加一

    public Queue_Array() {
        this(defaultSize);
    }

    public Queue_Array(int size) {
        realSize = size;
        header = 0;
        trailer = 0;
        Q = new Object[realSize];
    }

    @Override
    public int getSize() {
        return ((trailer - header) % realSize);
    }

    @Override
    public boolean isEmpty() {
        return (header == trailer);
    }

    @Override
    public T front() throws ExceptionQueueEmpty {
        if(isEmpty())
            throw new ExceptionQueueEmpty("错误18：队列为空");
        return (T)Q[trailer];
    }

    @Override
    public void enqueue(T obj) throws ExceptionQueueFull {
        if(getSize() == realSize - 1)
            throw new ExceptionQueueFull("错误19：队列溢出");
        Q[trailer] = obj;
        trailer = (trailer + 1) % realSize;
    }

    @Override
    public T dequeue() throws ExceptionQueueEmpty {
        if(isEmpty())
            throw new ExceptionQueueEmpty("错误18：队列为空");
        Object elem = Q[header];
        Q[header] = null;
        header = (header + 1) % realSize;
        return (T)elem;
    }

    @Override
    public void Traversal() {
        for(int i=header; i<trailer; i++) {
            System.out.print(Q[i] + " ");
        }
        System.out.println();
    }
}
