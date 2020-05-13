package Sequence.Stack;

import Exception.ExceptionStackEmpty;

public interface Stack<T> {
    //获得栈中元素的个数
    public int getSize();
    //判断栈是否为空
    public boolean isEmpty();
    //获取栈顶的元素（但不出栈）
    public T top() throws ExceptionStackEmpty;
    //入栈
    public void push (T ele);
    //出栈
    public T pop() throws ExceptionStackEmpty;
}
