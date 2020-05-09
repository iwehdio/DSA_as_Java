package Domin;

public class Fib {
    private int[] Arr;
    private int max_num = 5;
    private int N;
    private int n;
    private int index;

    public Fib(int N) {
        Arr = new int[max_num];
        this.N = N;
        this.generateTable();
    }

    private int generateTable(){
        if(this.N <= 0) return -1;
        else if(this.N == 1) {
            Arr[0] = 1;
            return 1;
        }else {
            Arr[0] = 1;
            Arr[1] = 1;
        }
        int i = 1;
        while (Arr[this.n = i++] < this.N) {
            if(i >= max_num) this.expand();
            Arr[i] = Arr[i-1] + Arr[i-2];
        }
        this.index = i;
        this.prev();
        return this.n;
    }

    public int prev(){
        return --this.index;
    }

    public int get(){
        return this.Arr[this.index-1];
    }

    public void show(){
        if(this.n == 0){
            System.out.println("向量为空");
        } else {
            System.out.print("[");
            for (int i = 0; i < this.n; i++) {
                System.out.print(this.Arr[i] + ", ");
            }
            System.out.println(this.Arr[this.n] + "]");
        }
    }

    private int expand(){
        int new_size = this.max_num * 2;
        int[] B = new int[new_size];
        for(int i = 0; i < this.max_num; i++){
            B[i] = this.Arr[i];
        }
        max_num = new_size;
        this.Arr = B;
        System.out.println("Fib数组扩容完成，最大容量为" + this.max_num);
        return new_size;
    }

}
