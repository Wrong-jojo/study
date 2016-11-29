package gzr.reflect;

import gzr.object.Chinese;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * getFields()与getDeclaredFields()区别 转载自 http://mxdxm.iteye.com/blog/927990
 * Created by gaozengrong on 16/11/29.
 *
 * getFields()与getDeclaredFields()区别:getFields()只能访问类中声明为公有的字段,私有的字段它无法访问，能访问从其它类继承来的公有方法.getDeclaredFields()能访问类中所有的字段,与public,private,protect无关，不能访问从其它类继承来的方法
 * getMethods()与getDeclaredMethods()区别:getMethods()只能访问类中声明为公有的方法,私有的方法它无法访问,能访问从其它类继承来的公有方法.getDeclaredFields()能访问类中所有的字段,与public,private,protect无关,不能访问从其它类继承来的方法
 * getConstructors()与getDeclaredConstructors()区别:getConstructors()只能访问类中声明为public的构造函数.getDeclaredConstructors()能访问类中所有的构造函数,与public,private,protect无关
 */
public class Esg {
    public static void main(String[] args) {
        Class c1 = Chinese.class;

        Field[] fs = c1.getFields();
        System.out.println("*******getFields()*********");
        for (Field f : fs) {
            System.out.println(f.getName());
        }
        System.out.println("*******getDeclaredFields()*********");
        fs = c1.getDeclaredFields();
        for (Field f : fs) {
            System.out.println(f.getName());
        }
        System.out.println("*******getMethods()*********");
        Method[] md = c1.getMethods();
        for (Method aMd : md) {
            System.out.println(aMd.getName());
        }
        System.out.println("*******getDeclaredMethods()*********");
        md = c1.getDeclaredMethods();
        for (Method aMd : md) {
            System.out.println(aMd.getName());
        }

        System.out.println("*******getConstructors()*********");
        Constructor[] con = c1.getConstructors();
        for (Constructor aCon : con) {
            System.out.println(aCon.getName());
        }
        System.out.println("*******getDeclaredConstructors()*********");
        con = c1.getDeclaredConstructors();
        for (Constructor aCon : con) {
            System.out.println(aCon.getName());
        }
    }
}


