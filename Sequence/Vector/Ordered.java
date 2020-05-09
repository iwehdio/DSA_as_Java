package Sequence.Vector;

public interface Ordered<T extends Comparable> {

    //唯一化
    public int uniquify();

    //冒泡排序
    public void bubbleSort(int left, int right);
    public void bubbleSort();
    //归并排序
    public void mergeSort(int left, int right);
    public void mergeSort();

    //二分查找
    public int binsearch(T e, int left, int right);
    public int binsearch(T e);

    //Fib查找
    public int fibsearch(T e, int left, int right);
    public int fibsearch(T e);
}
