package Test.AsVector;

import Domin.User;
import Sequence.Vector.Vector;
import Sequence.Vector.Vector_ExtArray;

public class Vector_ExtArray_AsObject_Test {
    public static void main(String[] args) {

        Vector<User> vector = new Vector_ExtArray<User>();
        System.out.println("空向量：");
        vector.show();
        System.out.println("判空：" + vector.isEmpty());
        System.out.println("规模：" + vector.getSize());

        int num = 10;
        int doAt = 5;
        User new_data = new User(20, 22, "10086" + Integer.toString(20 * 2));
        for (int i=0; i < num; i++){
            vector.insert(i, new User(i, 22, "10086" + Integer.toString(i * 2)));
        }
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

        //测试异常
        vector.get(num + 1);

    }
}
