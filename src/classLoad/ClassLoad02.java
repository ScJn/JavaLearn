package classLoad;

/**
 * for the 4 classLoader
 */
public class ClassLoad02 {

    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
//        System.out.println(System.getProperty("java.class.path"));
        String string=new String("sdd");
        System.out.println(string.getClass().getClassLoader());
        ClassLoadTest01 test01=new ClassLoadTest01();
        System.out.println(test01.getClass().getClassLoader());
    }
}
