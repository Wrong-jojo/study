package gzr.serial;

import gzr.object.Person;

import java.io.*;
import java.text.MessageFormat;

/**
 * 测试对象的序列化和反序列
 * Created by gaozengrong on 16/11/22.
 */
public class ObjSerializeAndDeserialize {
    public static void main(String[] args) throws Exception {
        SerializePerson();              //序列化Person对象
        Person deserializePerson = DeserializePerson();//反序列Peron对象
        System.out.println(MessageFormat.format("name={0},age={1},sex={2}",
                deserializePerson.getName(), deserializePerson.getAge(), deserializePerson.getSex()));
    }

    /**
     * MethodName: SerializePerson
     * Description: 序列化Person对象
     */
    private static void SerializePerson() throws IOException {
        Person person = new Person();
        person.setName("gaozengrong");
        person.setAge(25);
        person.setSex("男");
        // ObjectOutputStream 对象输出流，将Person对象存储到Person.txt文件中，完成对Person对象的序列化操作
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
                new File("/Users/gaozengrong/Downloads/Person.txt")));
        oo.writeObject(person);
        System.out.println("Person对象序列化成功！");
        oo.close();
    }

    /**
     * MethodName: DeserializePerson
     * Description: 反序列Perons对象
     */
    private static Person DeserializePerson() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File("/Users/gaozengrong/Downloads/Person.txt")));
        Person person = (Person) ois.readObject();
        System.out.println("Person对象反序列化成功！");
        return person;
    }
}
