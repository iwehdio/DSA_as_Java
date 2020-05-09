package Sequence.Comparator;

import Domin.User;

public class ComparatorAsUser implements Comparator{
    //User 类的比较器，先比Id大小，再比Age大小，最后是PhoneNumber长度
    @Override
    public int compare(Object a, Object b) {
        int res;
        User user_a = (User) a;
        User user_b = (User) b;
        if (user_a.equals(user_b)) {
            res = 0;
        } else {
            int comForId = Integer.compare(user_a.getId(), user_b.getId());
            if (comForId == 0) {
                int comForAge = Integer.compare(user_a.getAge(), user_b.getAge());
                if (comForAge == 0) {
                    res = Integer.compare(user_a.getPhoneNumber().length(), user_b.getPhoneNumber().length());
                } else {
                    res = comForAge;
                }
            } else {
                res = comForId;
            }
        }
        return res;
    }
}
