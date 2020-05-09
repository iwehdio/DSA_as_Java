package Test.AsVector;

import Sequence.Vector.Vector;
import Sequence.Vector.Vector_ExtArray;

public class Vector_ExtArray_Test {
    public static void main(String[] args) {

        Vector<Integer> vector = new Vector_ExtArray<Integer>();
        System.out.println("空向量：");
        vector.show();
        System.out.println("判空：" + vector.isEmpty());
        System.out.println("规模：" + vector.getSize());

        int num = 10;
        int doAt = 5;
        int new_data = doAt * 2;
        for (int i=0; i < num; i++){
            vector.insert(i, i*i);
        }
        vector.show();
        vector.insert(3, doAt * doAt);
        System.out.println("插入数据后");
        vector.show();

        System.out.println("规模：" + vector.getSize());
        System.out.println("在秩为" + doAt + "的数据为：" + vector.get(doAt));

        vector.replace(doAt, new_data);
        System.out.println("将在秩为" + doAt + "的数据替换为：" + new_data);
        System.out.println("替换后：");
        vector.show();

        vector.remove(doAt);
        System.out.println("将在秩" + doAt + "的数据移除后新数据为：" + new_data);
        System.out.println("删除后：");
        vector.show();
        System.out.println("规模：" + vector.getSize());

        int left = 2;
        int rigth = 5;
        System.out.println(left + "到" + rigth + "之间删除");
        vector.remove(left, rigth);
        vector.show();

        //测试异常
        vector.get(num + 1);

    }
}
