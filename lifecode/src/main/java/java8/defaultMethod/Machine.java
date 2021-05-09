package java8.defaultMethod;

public interface Machine extends Flyable{
    @Override
    default void fly() {
        System.out.println("equipment a machine and fly");
    }

    @Override
    default void up() {
        turn();
        System.out.println("using fuel to arise.");
    }

    static void turn(){
        System.out.println("machine turn on");
    }
}
