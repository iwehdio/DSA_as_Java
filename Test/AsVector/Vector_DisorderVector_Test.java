package Test.AsVector;

import Sequence.Vector.Vector;
import Sequence.Vector.DisorderVector;

public class Vector_DisorderVector_Test {
    public static void main(String[] args) {

        DisorderVector<Integer> vector = new DisorderVector<Integer>();
        int num = 10;
        int doAt = 25;
        for (int i=0; i < num; i++){
            vector.insert(i, i*i);
        }
        vector.insert(3, doAt);
        vector.insert(5, doAt);
        vector.insert(7, doAt);
        vector.insert(9, doAt);
        vector.insert(11, 64);
        vector.insert(13, 0);
        System.out.println("插入数据后:");
        vector.show();

        System.out.println("寻找数据为" + doAt + "的位置:");
        int Rank = vector.find(doAt);
        System.out.println(Rank);

        System.out.println("去重:");
        int removeNum = vector.uniquify();
        vector.show();
        System.out.println("共移除了" + removeNum + "个重复元素");

    }

}
