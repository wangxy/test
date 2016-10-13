package prototype;

/**
 * Created by xwang on 5/23/16.
 */
public class PrototypeA implements Prototype {
    private String name;
    private String address;
    private double salary;

    PrototypeA(String name, String address, double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    @Override
    public Prototype clone() {
        try {
            return (PrototypeA)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "PrototypeA{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                '}';
    }
}
