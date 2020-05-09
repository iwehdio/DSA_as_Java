package Test.AsVector;

import Domin.Fib;

public class Fib_Test {
    public static void main(String[] args) {
        int num = 100;
        Fib fib = new Fib(num);
        fib.show();
        System.out.println("最后一项" + fib.get());
        fib.prev();
        System.out.println("前移一项" + fib.get());
    }
}
