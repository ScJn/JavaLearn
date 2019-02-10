package classLoad;

public class ClassLoadTest01 {


    static {
        System.out.println("static init block in ClassLoadTest01");
    }
    ClassLoadTest01(){
        System.out.println("construct ClassLoadTest01");
    }
    public static void main(String[] args) throws Exception {

//        m4();

//        Active reference: 3 ways
        TestClass testClass=new TestClass();
        Class cl=Class.forName("classLoad.TestClass");
        System.out.println(TestClass.name);

//        passive reference: 4 ways
        System.out.println(TestClass.MAX);
        TestClass[] ts=new TestClass[10];
        System.out.println(TestClass.height);  //load the father class
        System.out.println(TestClass.MIN);
    }


    /*
    构造类时发现类未被加载会加载
    加载只会加载一次，如果父类没有加载，加载父类，子类构造器会调用父类构造器
    调用 clinit() 由静态块和静态语句拼接而成的
     */
    static void m1(){
        TestClass testClass=new TestClass();
    }

    static void m2(){
        Father father=new Father();
        TestClass testClass=new TestClass();
    }

    static void m3(){

        TestClass testClass=new TestClass();
        Father father=new Father();
    }

    static void m4(){
        TestClass testClass=new TestClass();
        TestClass testClass2=new TestClass();

    }



}


class TestClass extends Father{


    //the static init block and static statement will combine orderly for the clinit()
    static {
        System.out.println("static init block in TestClass");
        name="dsd";
    }
    public static String name="ddd";
    public static final int MAX=100;


    TestClass(){
        System.out.println("construct the TestClass");
        System.out.println(name);
    }
}

class Father{

    public static int height=10;
    public static final int MIN=0;

    static {
        System.out.println("static init block in Father!");
    }
    Father(){
        System.out.println("construct the Father!");
    }
}