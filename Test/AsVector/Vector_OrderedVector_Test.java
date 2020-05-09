package Test.AsVector;

import Sequence.Vector.Vector;
import Sequence.Vector.OrderedVector;
import Sequence.Vector.Vector_ExtArray;
import java.util.Random;

public class Vector_OrderedVector_Test {
    public static void main(String[] args) {
        OrderedVector<Integer> vector = new OrderedVector<Integer>();
        Random random = new Random();
        int num = 20;

        System.out.println("查找：");
        int doAt1 = 3*3;
        int doAt2 = 7*7;
        int doAt3 = 11*11;
        int doAt4 = 15*15;
        for (int i=0; i < num; i++){
            vector.insert(i, i * i);
        }
        System.out.println("插入数据后");
        vector.show();

        int Rank = vector.binsearch_A(doAt1);
        System.out.println("binsearch_A:数据" + doAt1 + "在位置" + Rank);
        Rank = vector.binsearch_B(doAt2);
        System.out.println("binsearch_B:数据" + doAt2 + "在位置" + Rank);
        Rank = vector.binsearch_A(doAt3);
        System.out.println("binsearch_C:数据" + doAt3 + "在位置" + Rank);
        Rank = vector.fibsearch(doAt4);
        System.out.println("fibsearch:数据" + doAt4 + "在位置" + Rank);

        System.out.println("-------------------------");
        System.out.println("排序：");
        OrderedVector<Integer> vector1 = new OrderedVector<Integer>();
        for (int i=0; i < num; i++){
            vector1.insert(i, random.nextInt(100));
        }
        System.out.println("插入数据后");
        vector1.show();
        System.out.println("冒泡排序：");
        vector1.bubbleSort();
        vector1.show();

        OrderedVector<Integer> vector2 = new OrderedVector<Integer>();
        for (int i=0; i < num; i++){
            vector2.insert(i, random.nextInt(100));
        }
        System.out.println("插入数据后");
        vector2.show();
        System.out.println("归并排序：");
        vector2.mergeSort();
        vector2.show();

    }

}
