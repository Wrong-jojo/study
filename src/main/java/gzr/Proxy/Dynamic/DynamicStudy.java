package gzr.Proxy.Dynamic;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 深入理解java proxy机制 转载自 http://blog.csdn.net/rokii/article/details/4046098
 * Created by gaozengrong on 16/11/29.
 */
public class DynamicStudy {
    public static void main(String[] args) {
        DynamicProxy proxy = new DynamicProxy();
        BookFacade bookFacade = (BookFacade) proxy.bind(new BookFacadeImpl());
        //调用关系 bookFacade.addBook()-->invocationHandler.invoke()-->BookFacadeImpl.addBook();
        bookFacade.addBook();
        System.out.println(bookFacade.getClass().getName());
        printClassDefinition(bookFacade.getClass());
    }


    private static String getModifier(int modifier){
        String result = "";
        switch(modifier){
            case Modifier.PRIVATE:
                result = "private";
            case Modifier.PUBLIC:
                result = "public";
            case Modifier.PROTECTED:
                result = "protected";
            case Modifier.ABSTRACT :
                result = "abstract";
            case Modifier.FINAL :
                result = "final";
            case Modifier.NATIVE :
                result = "native";
            case Modifier.STATIC :
                result = "static";
            case Modifier.SYNCHRONIZED :
                result = "synchronized";
            case Modifier.STRICT  :
                result = "strict";
            case Modifier.TRANSIENT :
                result = "transient";
            case Modifier.VOLATILE :
                result = "volatile";
            case Modifier.INTERFACE :
                result = "interface";
        }
        return result;
    }

    private static void printClassDefinition(Class clz){

        String clzModifier = getModifier(clz.getModifiers());
        if(clzModifier!=null && !"".equals(clzModifier)){
            clzModifier = clzModifier + " ";
        }
        String superClz = clz.getSuperclass().getName();
        if(superClz!=null && !"".equals(superClz)){
            superClz = "extends " + superClz;
        }

        Class[] interfaces = clz.getInterfaces();

        String inters = "";
        for(int i=0; i<interfaces.length; i++){
            if(i==0){
                inters += "implements ";
            }
            inters += interfaces[i].getName();
        }

        System.out.println(clzModifier +clz.getName()+" " + superClz +" " + inters ); //输出com.sun.proxy.$Proxy0 extends java.lang.reflect.Proxy implements gzr.Proxy.Dynamic.BookFacade
        System.out.println("{");

//        Field[] fields = clz.getFields();
        Field[] fields = clz.getDeclaredFields();   //这里获得的field(属性,不包括方法)为com.sun.proxy.$Proxy0 的所有private public protect方法
        for (Field field : fields) {
            String modifier = getModifier(field.getModifiers());
            if (modifier != null && !"".equals(modifier)) {
                modifier = modifier + " ";
            }
            String fieldName = field.getName();
            String fieldType = field.getType().getName();
            System.out.println("    " + modifier + fieldType + " " + fieldName + ";");
        }

        System.out.println();

        Method[] methods = clz.getDeclaredMethods();
        for (Method method : methods) {
            String modifier = getModifier(method.getModifiers());
            if (modifier != null && !"".equals(modifier)) {
                modifier = modifier + " ";
            }

            String methodName = method.getName();

            Class returnClz = method.getReturnType();
            String retrunType = returnClz.getName();

            Class[] clzs = method.getParameterTypes();
            String paraList = "(";
            for (int j = 0; j < clzs.length; j++) {
                paraList += clzs[j].getName();
                if (j != clzs.length - 1) {
                    paraList += ", ";
                }
            }
            paraList += ")";

            clzs = method.getExceptionTypes();
            String exceptions = "";
            for (int j = 0; j < clzs.length; j++) {
                if (j == 0) {
                    exceptions += "throws ";
                }

                exceptions += clzs[j].getName();

                if (j != clzs.length - 1) {
                    exceptions += ", ";
                }
            }

            exceptions += ";";

            String methodPrototype = modifier + retrunType + " " + methodName + paraList + exceptions;

            System.out.println("    " + methodPrototype);

        }
        System.out.println("}");
    }

}
