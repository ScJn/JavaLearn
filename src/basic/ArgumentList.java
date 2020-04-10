package basic;

import org.junit.Test;

/**
 * @author scjn
 * @date 2020/4/9 21:41
 */
public class ArgumentList {



    public ArgumentList(){}

    public static void main(String[] args) {
//        new ArgumentList("dsad", 2, null);
//        Integer[] integers = {1, 2, 3, 4};
//        new ArgumentList(integers); // regards it as a list not one arg
//        System.out.println(integers);
        ArgumentList argumentList = new ArgumentList();
        argumentList.testOverwrite(1,"sda");

    }

    public void testOverwrite(float... args){
        System.out.println(1);
    }

    public void testOverwrite(int... args){
        System.out.println(2);
    }

    /**
     * can't tell
     */
    @Test
    public void test(){
        testOverwrite();
    }

//    public void testOverwrite(float i, String... args){
//        System.out.println(3);
//    }

    public void testOverwrite(char i, String... args){
        System.out.println(4);
    }
}

class IntegerAndInt{
    public static void main(String[] args) {
        System.out.println(int[].class);
        System.out.println(Integer[].class);
    }
}
