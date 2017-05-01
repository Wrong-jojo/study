package gzr.reflect;

/**
 * 定义一个“人”类
 * @author zengrong.gzr
 * @date 2017/05/02
 */
public class Person {
    private String name;
    private int age;
    private double salary;

    public Person() {

    }

    public Person(String name, int age, double salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
