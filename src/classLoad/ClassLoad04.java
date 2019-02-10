package classLoad;

import java.io.File;

public class ClassLoad04 {

    void print(){
        System.out.println(this.getClass().getResource("/").getPath());
    }
    public static void main(String[] args) throws ClassNotFoundException {

        // all loaded by app Loader

        FileClassLoader loader=new FileClassLoader("D:\\javas\\java_learning\\src\\classLoad");
        FileClassLoader loader1=new FileClassLoader("D:\\javas\\java_learning\\src\\classLoad");
        Class clazz=loader.findClass("classLoad.ClassLoad02");
        Class clazz2=loader.findClass("classLoad.ClassLoad02");
        Class c3=loader1.findClass("classLoad.ClassLoad02");
        System.out.println(clazz.getClassLoader());
        System.out.println(clazz.hashCode());
        System.out.println(clazz2.hashCode()); //the same classLoader load the same class;
        System.out.println(c3.hashCode());


        // loaded by user-defined loader
        FileClassLoader loader2=new FileClassLoader("D:");
        FileClassLoader loader3=new FileClassLoader("D:");
        Class c4=loader2.findClass("hjx.Sum");
        Class c5=loader3.findClass("hjx.Sum");
        System.out.println(c4);
        System.out.println(c4.getClassLoader());

        System.out.println(c4.hashCode());
        System.out.println(c5.hashCode()); //different classLoader


    }
}
