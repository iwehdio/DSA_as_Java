package Sequence.Vector;
import Exception.ExceptionBoundaryViolation;

public class Vector_ExtArray<T> implements Vector<T> {
    //protected 可以在子类中使用
    protected int max_num = 8;      //初始容量
    protected int n = 0;
    protected Object[] Array;

    public Vector_ExtArray() {
        Array = new Object[max_num];
        n = 0;
    }

    public Vector_ExtArray(Vector<T> vector, int left, int right) {
        if(left < 0 || right > vector.getSize())
            throw new ExceptionBoundaryViolation("错误2：指定的复制区域错误");
        n = right - left;
        Array = new Object[n];
        for(int i=left, j=0; i<right; i++, j++){
            Array[j] = vector.get(i);
        }
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
        } else if (n == max_num) {
            System.out.println("容量不足,需要扩容");
            this.expand();
        }
        for (int index = n; index > rank; index--) {
            Array[index] = Array[index-1];
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

    private int expand(){
        int new_size = max_num * 2;
        Object[] B = new Object[new_size];
        for(int index = 0; index < max_num; index++){
            B[index] = Array[index];
        }
        max_num = new_size;
        Array = B;
        System.out.println("扩容完成，最大容量为" + max_num);
        return new_size;
    }

}

