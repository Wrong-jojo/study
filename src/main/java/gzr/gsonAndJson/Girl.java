package gzr.gsonAndJson;

/**
 * @author zengrong.gzr
 * @date 2017/04/06
 */
public class Girl {
    private String sex;

    private Integer age;

    private String name;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    //女孩不想让别人知道她的年龄 去掉改属性
    //public Integer getAge() {
    //    return age;
    //}

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
