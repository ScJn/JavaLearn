package reflection;

import leetcode.array.Sum;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflect01 {

    public static void main(String[] args) throws Exception {
        Class clazz=Class.forName("leetcode.array.Sum");

        System.out.println(clazz.getName()); //全名
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getField("name"));

        //list
        clazz.getMethods();
        clazz.getConstructors();

        //method
        Method method=clazz.getMethod("twoSum", int[].class, int.class);
        method.invoke(new int[]{2,3},2);
        method.setAccessible(true); //do not check the access

        // constructor
        Constructor constructor=clazz.getConstructor();
        Sum s2= (Sum) constructor.newInstance();

        //field
        @Deprecated
        Field field= clazz.getField("name");
        field.set(s2,"dd");


        System.out.println(s2.name);
        Student student;

        Class clazz2=Class.forName("reflection.Student");
        MyTable annotation= (MyTable) clazz2.getAnnotation(MyTable.class);
        annotation.value();

        Field sf=clazz2.getDeclaredField("name");
        MyField mf=sf.getAnnotation(MyField.class);
        System.out.println(mf.name());







    }
}
