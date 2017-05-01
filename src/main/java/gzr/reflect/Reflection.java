package gzr.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author zengrong.gzr
 * @date 2017/05/02
 */
public class Reflection {
    public Object copy(Object object) throws Exception {
        //通过传入的Object得到该实例对应的类的Class对象
        Class<?> classType = object.getClass();

        //通过Class得到该类的Constructor对象
        Constructor<?> cons = classType.getConstructor();

        //通过反射机制使用构造方法得到一个对象，用来接受复制的内容
        Object retObject = cons.newInstance();

        //取到实例对应的类的所有成员变量
        Field[] fields = classType.getDeclaredFields();
        for (Field field : fields) {
            String nameOfField = field.getName();
            /*组装成员变量的get、set方法*/
            String fristWord = nameOfField.substring(0, 1).toUpperCase();
            String getMethodName = "get" + fristWord + nameOfField.substring(1);
            String setMethodName = "set" + fristWord + nameOfField.substring(1);
            //通过反射创建类中方法的对象
            Method getMethod = classType.getMethod(getMethodName);
            Method setMethod = classType.getMethod(setMethodName, field.getType());
            /*使用get方法从传入对象取值，使用set方法将取出的值赋给等待复制的retObject*/
            Object value = getMethod.invoke(object);
            setMethod.invoke(retObject, value);
        }
        return retObject;
    }

    public static void main(String[] args) throws Exception {
        //使用反射创建一个person实例
        Class<?> classType = Person.class;
        Constructor cons = classType.getConstructor(String.class, int.class, double.class);
        //使用带参数的构造方法创建对象
        Object perOfLee = cons.newInstance("Lee", 25, 8000);

        //使用反射调用copy方法
        Class<?> classOfReflect = Class.forName("gzr.reflect.Reflection");
        Object reflect = classOfReflect.newInstance();
        Method methodOfCopy = classOfReflect.getMethod("copy", Object.class);
        Object finalObject = methodOfCopy.invoke(reflect, perOfLee);
        Person copyPerson = (Person)finalObject;

        //print
        System.out.println(copyPerson.getName() + ", " + copyPerson.getAge() + ", " + copyPerson.getSalary());
    }
}
