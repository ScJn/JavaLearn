package java8.defaultMethod;

public interface Angle {
    default void fly(){
        System.out.println("become an angle and fly");
    }

    default void speedUp(){
        System.out.println("use magic power to speed up");
    }

}
