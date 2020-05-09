package Sequence.Vector;

import Domin.Fib;

public class OrderedVector<T extends Comparable> extends Vector_ExtArray<T> implements Ordered<T> {

    @Override
    public int uniquify() {
        int left = 0;               //双指针
        int right = 0;
        while(++right < super.n){
            if(!super.Array[left].equals(super.Array[right])){
                super.Array[++left] = super.Array[right];
            }
        }
        super.n = ++left;           //左指针左侧是结果
        return right - left;
    }

    @Override
    public void bubbleSort(int left, int right) {
        while (left < (right = bubble(left, right)));
    }

    @Override
    public void bubbleSort() {
        bubbleSort(0, super.n);
    }

    private int bubble(int left, int right){
        int last = left;
        while (++left < right){
            if(((T)super.Array[left]).compareTo(super.Array[left-1]) == -1){
                last = left;
                T temp = (T)super.Array[left-1];
                super.Array[left-1] = super.Array[left];
                super.Array[left] = temp;
            }
        }
        return last;
    }


    @Override
    public void mergeSort(int left, int right) {
        if(right - left < 2)return;
        int mid = (left + right) >> 1;
        mergeSort(left, mid);
        mergeSort(mid, right);
        merge(left, mid, right);
    }

    @Override
    public void mergeSort() {
        mergeSort(0, super.n);
    }

    private void merge(int left, int mid, int right) {
        Vector_ExtArray<T> vector = new Vector_ExtArray<T>(this, left, mid);
        int lb = mid - left;
        int lc = right - mid;
        for(int i=0, j=0, k=0; (j<lb) || (k<lc); ) {
            if((j<lb) && (lc<=k || (vector.get(j).compareTo(super.Array[k + mid])<1))){
                super.Array[left + i++] = vector.get(j++);
            }
            if((k<lc) && (lb<=j || (vector.get(j).compareTo(super.Array[k + mid])==1))){
                super.Array[left + i++] = super.Array[k++ + mid];
            }
        }
    }
/* private void merge(int left, int mid, int right) {
        Vector_ExtArray<T> vector_b = new Vector_ExtArray<T>(this, left, mid);
        Vector_ExtArray<T> vector_c = new Vector_ExtArray<T>(this, mid, right);
        int lb = mid - left;
        int lc = right - mid;
        for(int i=0, j=0, k=0; (j<lb) || (k<lc); ) {
            if((j<lb) && (lc<=k || (vector_b.get(j).compareTo(vector_c.get(k))<1))){
                super.Array[i++] = vector_b.get(j++);
            }
            if((k<lc) && (lb<=j || (vector_b.get(j).compareTo(vector_c.get(k))==1))){
                super.Array[i++] = vector_c.get(k++ + lb);
            }
        }
    }
*/

    public int binsearch_A(T e, int left, int right) {
        while(left < right){
            int mid = (left + right) >> 1;
            if(e.compareTo(super.Array[mid]) == -1){
                right = mid;
            } else if(e.compareTo(super.Array[mid]) == 1){
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    public int binsearch_A(T e) {
        return binsearch_A(e, 0, super.n);
    }

    public int binsearch_B(T e, int left, int right) {
        int mid = (left + right) >> 1;
        while(right - left > 1){
            mid = (left + right) >> 1;
            if(e.compareTo(super.Array[mid]) == -1){
                right = mid;
            } else {
                left = mid ;
            }
        }
        return (e.equals(super.Array[mid]))? mid : -1;
    }
    public int binsearch_B(T e) {
        return binsearch_A(e, 0, super.n);
    }

    @Override
    public int binsearch(T e, int left, int right) {
        while(left < right){
            int mid = (left + right) >> 1;
            if(e.compareTo(super.Array[mid]) == -1){
                right = mid;
            } else if(e.compareTo(super.Array[mid]) == 1){
                left = mid + 1;
            }
        }
        return --left;
    }

    @Override
    public int binsearch(T e) {
        return binsearch(e, 0, super.n);
    }

    @Override
    public int fibsearch(T e, int left, int right) {
        Fib fib = new Fib(right - left);
        int mid;
        while (right - left > fib.get()){
            fib.prev();
            mid = left + fib.get() -1;
            if(e.compareTo(super.Array[mid]) == -1){
                right = mid;
            } else if(e.compareTo(super.Array[mid]) == 1){
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    @Override
    public int fibsearch(T e) {
        return fibsearch(e, 0, super.n);
    }


}
