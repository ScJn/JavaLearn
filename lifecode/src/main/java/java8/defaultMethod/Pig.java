package java8.defaultMethod;

public class Pig implements Flyable, Angle, Machine, Superman{

    @Override
    public void fly() {
        up();
        System.out.println("standing at the cusp of the Ages, pig can also fly");
        speedUp();
    }

    @Override
    public void speedUp() {
        Superman.super.speedUp();
    }


    /**
     * 1. class always win
     * 2. concrete interface win
     * 3. need to specify it when cannot be determined by first two step
     */
    public static void main(String[] args) {
        new Pig().fly();
        Machine.turn();
    }
}
