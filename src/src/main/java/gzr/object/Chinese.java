package gzr.object;

/**
 * Created by gaozengrong on 16/11/29.
 */
public class Chinese extends Person{
    private static final long serialVersionUID = 1082126844948509353L;

    public static final String country = "China";

    private String province;

    private String city;

    public Chinese(String province, String city) {
        this.province = province;
        this.city = city;
    }

    private Chinese(Chinese chinese){
        this.province = chinese.getProvince();
        this.city = chinese.getCity();
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

}
