package basic.methodAndField;

public class ConstructorTest {

    class Life{
        Life(int i){
            System.out.println("life");
        }
    }

    class Dog extends Life{
        Dog(int i){
            super(i);
        }
    }

}

