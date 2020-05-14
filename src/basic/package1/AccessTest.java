package basic.package1;

public class AccessTest{

    public static void main(String[] args) {
        PrivateClass privateClass = new PrivateClass();
//        privateClass.pri();
    }

    private static void test1() {
        AccessTest accessTest = new AccessTest();
        Car car = new Car();
        car.pro();
    }
}

class PrivateClass{
    private void pri(){
        System.out.println("pri");
    }
}


