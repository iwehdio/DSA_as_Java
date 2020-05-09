package Sequence.Vector;
import Exception.ExceptionBoundaryViolation;

public class Vector_Array<T> implements Vector<T> {

    private final int max_num = 1024;
    private int n = 0;
    private Object[] Array;

    public Vector_Array() {
        Array = new Object[max_num];
        n = 0;
    }

    @Override
    public int getSize() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return (n == 0)? true : false;
    }

    @Override
    public T get(int rank) throws ExceptionBoundaryViolation {
        if (rank < 0 || rank >= n){
            throw new ExceptionBoundaryViolation("错误0：秩越界");
        }
        return (T)Array[rank];
    }

    @Override
    public T replace(int rank, T new_obj) throws ExceptionBoundaryViolation {
        if (rank < 0 || rank >= n){
            throw new ExceptionBoundaryViolation("错误0：秩越界");
        }
        Object past_obj = Array[rank];
        Array[rank] = new_obj;
        return (T)past_obj;
    }

    @Override
    public T insert(int rank, T obj) throws ExceptionBoundaryViolation {
        if (rank < 0 || rank > n) {     //注意插入时对越界的判断，与n比较没有=号
            throw new ExceptionBoundaryViolation("错误0：秩越界");
        } else if (n + 1 > max_num) {
            throw new ExceptionBoundaryViolation("错误1：容量不足");
        }
        for (int index = n; index > rank; index--) {
            Array[n] = Array[n-1];
        }
        n++;
        Array[rank] = obj;
        return (T)obj;
    }

    @Override
    public T remove(int rank) throws ExceptionBoundaryViolation {
        if(rank < 0 || rank >= n) {
            throw new ExceptionBoundaryViolation("错误0：秩越界");
        }
        Object past_obj = Array[rank];
        for (int index = rank; index < n-1; index++){
            Array[index] = Array[index + 1];
        }
        n--;
        return (T)past_obj;
    }

    @Override
    public int remove(int left, int right){
        if(left == right) return 0;
        while(right < n){
            Array[left++] = Array[right++];
        }
        n = left;
        return right - left;
    }

    @Override
    public void show() {
        if(n == 0){
            System.out.println("向量为空");
        } else {
            System.out.print("[");
            for (int index = 0; index < n-1; index++) {
                System.out.print(this.get(index) + ", ");
            }
            System.out.println(this.get(n-1) + "]");
        }
    }


}
