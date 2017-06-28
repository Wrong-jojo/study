package gzr.copy;

import gzr.object.Chinese;
import gzr.object.Person;
import org.springframework.beans.BeanUtils;

/**
 * test some bean copy method
 *
 * @author zengrong.gzr
 * @date 2017/05/22
 */
public class BeanCopy {
    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(26);
        person.setName("gzr");
        person.setSex("male");

        Chinese chinese = new Chinese("浙江", "杭州");
        //通过spring bean copy来实现复制
        BeanUtils.copyProperties(person, chinese);

        //通过定义一个入参为父对象的构造函数 来拷贝基类的属性
        Chinese copyChinese = new Chinese(person);
    }
}
