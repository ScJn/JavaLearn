package design_pattern.factory;

public class Test {

    public static void main(String[] args) {
        Car byd=new BYD();
        Car bmw=new BMW();

        byd.run();
        bmw.run();

    }
}
