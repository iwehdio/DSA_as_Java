package Sequence.Stack;

import Exception.ExceptionStackEmpty;
import Exception.ExceptionStackFull;

public class Stack_Array<T> implements Stack<T> {

    private final static int defaultSize = 1024;        //默认容量
    private int realSize;
    private Object[] Array;
    private int top;

    public Stack_Array() {
        this(defaultSize);
    }

    public Stack_Array(int size) {
        realSize = size;
        this.Array = new Object[realSize];
        this.top = -1;
    }

    @Override
    public int getSize() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return (top < 0);
    }

    @Override
    public T top() throws ExceptionStackEmpty {
        if(isEmpty())
            throw new ExceptionStackEmpty("错误16：栈为空。");
        else
            return (T)Array[top];
    }

    @Override
    public void push(T ele)  throws ExceptionStackFull {
        if(top + 1 == realSize)
            throw new ExceptionStackFull("错误17：栈溢出。");
        else {
            top += 1;
            Array[top] = ele;
        }
    }

    @Override
    public T pop() throws ExceptionStackEmpty {
        if(isEmpty())
            throw new ExceptionStackEmpty("错误16：栈为空。");
        else {
            Object data = Array[top];
            Array[top] = null;
            top -= 1;
            return (T) data;
        }
    }
}
