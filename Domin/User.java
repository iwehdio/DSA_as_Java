package Domin;

public class User {

    private int id;
    private int age;
    private String phoneNumber;

    public User(int id, int age, String phoneNumber) {
        this.id = id;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                age == user.age &&
                phoneNumber.equals(user.phoneNumber);
    }

    @Override
    public String toString() {
        return "User{id=" + id +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                "}\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
