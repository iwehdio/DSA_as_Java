package Test.AsVector;

import Sequence.Sequence;
import Sequence.Sorter.Sorter;
import Sequence.Sorter.Sorter_Bubblesort;
import Sequence.Vector.OrderedVector;
import Sequence.Vector.Vector;
import Sequence.Vector.Vector_ExtArray;

import java.util.Random;

public class Comparator_Test {
    public static void main(String[] args) {

        Sorter_Bubblesort sorter_Bubblesort = new Sorter_Bubblesort();

        int num = 20;
        OrderedVector<Integer> vector = new OrderedVector<Integer>();
        Random random = new Random();
        for (int i=0; i < num; i++){
            vector.insert(i, random.nextInt(100));
        }
        System.out.println("插入数据后");
        vector.show();
        System.out.println("排序：");
        sorter_Bubblesort.sort(vector);
        vector.show();
    }
}
