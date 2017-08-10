package gzr.object;

import org.springframework.beans.BeanUtils;

/**
 * Created by gaozengrong on 16/11/29.
 */
public class Chinese extends Person {
    private static final long serialVersionUID = 1082126844948509353L;

    public static final String country = "China";

    private String province;

    private String city;

    public Chinese(String province, String city) {
        this.province = province;
        this.city = city;
    }

    /**
     * 传入父对象 调用BeanUtils.copyProperties进行拷贝
     *
     * @param person
     */
    public Chinese(Person person) {
        BeanUtils.copyProperties(person, this);
    }

    public Chinese() {

    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 加入中国国籍 定居江苏南通
     *
     * @param person
     * @return
     */
    public static Chinese joinChineseNationality(Person person) {
        Chinese chinese = new Chinese(person);
        chinese.setProvince("江苏");
        chinese.setCity("南通");
        return chinese;
    }
}
