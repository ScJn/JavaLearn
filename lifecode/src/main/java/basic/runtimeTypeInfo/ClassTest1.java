package basic.runtimeTypeInfo;

public class ClassTest1 {

    static class Base1{

    }
    static class Ex1 extends Base1{

    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

//        test1();
//        test2();
//        test3();
        Class<Ex1> ex1Class = Ex1.class;
        Class<? super Ex1> superclass = ex1Class.getSuperclass();
//        Class<Base1> s = ex1Class.getSuperclass();
        Object object = superclass.newInstance();

        if (object instanceof Base1) {
            System.out.println(true);
        }

        if (Base1.class.isInstance(object)) {
            System.out.println(true);
        }

        boolean assignableFrom = Base1.class.isAssignableFrom(Ex1.class);
        System.out.println(assignableFrom);

    }

    private static void test3() {
        Class<? extends Number> c = int.class;
        c = Double.class;
    }

    private static void test2() {
        Class<Integer> integerClass = int.class;
        Class<?> c = Integer.class;

        System.out.println(integerClass);
        System.out.println(c);
    }

    private static void test1() throws ClassNotFoundException {
        ClassTest1 clazz = new ClassTest1();
        Class<? extends ClassTest1> aClass = clazz.getClass();
        String name = aClass.getName();
        System.out.println(name);

        Class<?> aClass1 = Class.forName(name);
        System.out.println(aClass1);
    }
}
