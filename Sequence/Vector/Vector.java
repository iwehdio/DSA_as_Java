package Sequence.Vector;
import Exception.ExceptionBoundaryViolation;


public interface Vector<T> {
    //规模
    public int getSize();
    //判空
    public boolean isEmpty();
    //索引，有索引输入的都抛出下标越界异常
    public T get(int rank) throws ExceptionBoundaryViolation;
    //替换
    public T replace(int rank, T obj) throws ExceptionBoundaryViolation;
    //插入
    public T insert(int rank, T obj) throws ExceptionBoundaryViolation;
    //删除
    public T remove(int rank) throws ExceptionBoundaryViolation;
    public int remove(int left, int right) throws ExceptionBoundaryViolation;
    //显示
    public void show();
}
