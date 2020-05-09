
package Sequence.List.List;

import Iterator.Iterator;
import Sequence.List.Node.Position;
import Exception.ExceptionPositionInvalid;
import Exception.ExceptionBoundaryViolation;

public interface List<T> {
    //规模
    public int getSize();
    //判空
    public boolean isEmpty();
    //首元素
    public Position<T> first();
    //末元素
    public Position<T> last();
    //获取给定元素的前驱
    public Position<T> getPrev(Position<T> p)
            throws ExceptionPositionInvalid, ExceptionBoundaryViolation;
    //获取给定元素的后继
    public Position<T> getNext(Position<T> p)
            throws ExceptionPositionInvalid, ExceptionBoundaryViolation;
    //作为首元素插入
    public Position<T> insertFirst(T e);
    //作为末元素插入
    public Position<T> insertLast(T e);
    //在给定元素前插入
    public Position<T> insertBefore(Position<T> p, T e)
            throws  ExceptionPositionInvalid;
    //在给定元素后插入
    public Position<T> insertAfter(Position<T> p, T e)
            throws ExceptionPositionInvalid;
    //删除给定元素
    public T remove(Position<T> p)
            throws ExceptionPositionInvalid;
    //删除首元素
    public T removeFirst();
    //删除末元素
    public T removeLast();
    //替换给定元素
    public T replace(Position<T> p, T e)
            throws ExceptionPositionInvalid;
    //位置迭代器
    public Iterator positions();
    //元素迭代器
    public Iterator elements();
    //显示
    public void show();
}
