package Test.AsVector;

import Domin.User;
import Sequence.Comparator.ComparatorAsUser;
import Sequence.Sorter.Sorter_Bubblesort;
import Sequence.Vector.Vector_ExtArray;

public class Comparator_User_Test {
    public static void main(String[] args) {

        Sorter_Bubblesort sorter_Bubblesort = new Sorter_Bubblesort(new ComparatorAsUser());

        Vector_ExtArray<User> vector = new Vector_ExtArray<User>();

        vector.insert(0, new User(5, 19, "13568"));
        vector.insert(1, new User(4, 16, "13568"));
        vector.insert(2, new User(2, 17, "13568"));
        vector.insert(3, new User(1, 11, "13568"));
        vector.insert(4, new User(3, 14, "13568"));
        vector.insert(5, new User(2, 11, "13568"));
        vector.insert(6, new User(3, 20, "13568"));
        vector.insert(6, new User(3, 20, "1356648"));

        System.out.println("插入数据后");
        vector.show();
        System.out.println("排序：");
        sorter_Bubblesort.sort(vector);
        vector.show();
    }
}
