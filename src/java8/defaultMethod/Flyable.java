package java8.defaultMethod;

public interface Flyable {
    void fly();
    default void up(){
        System.out.println("up");
    }
}
