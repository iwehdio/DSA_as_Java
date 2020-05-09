package Sequence.Vector;

import Exception.ExceptionBoundaryViolation;

public class DisorderVector<T> extends Vector_ExtArray<T>{

    public int find(T e, int left, int right){
        if(left < 0 || right > super.n) return -1;      //right是右哨兵节点，可以等于n
        while((left < right--) && (!e.equals(super.Array[right])));
        return right;
    }
    public int find(T e){
        return find(e, 0, super.n);
    }

    //唯一化
    public int uniquify(){
        int removeNum = 0;
        for(int index=1 ; index<super.n; index++){       //从第二个元素开始
            int Rank = this.find((T)super.Array[index], 0, index);
            if(Rank != -1){
                remove(index--);
                removeNum++;

            }
        }
        return removeNum;
    }

    public DisorderVector() {
        super();
    }

    @Override
    public T remove(int rank) throws ExceptionBoundaryViolation {
        return super.remove(rank);
    }

    @Override
    public int remove(int left, int right) {
        return super.remove(left, right);
    }

    @Override
    public int getSize() {
        return super.getSize();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public T get(int rank) throws ExceptionBoundaryViolation {
        return super.get(rank);
    }

    @Override
    public T replace(int rank, T new_obj) throws ExceptionBoundaryViolation {
        return super.replace(rank, new_obj);
    }

    @Override
    public T insert(int rank, T obj) throws ExceptionBoundaryViolation {
        return super.insert(rank, obj);
    }

    @Override
    public void show() {
        super.show();
    }
}
