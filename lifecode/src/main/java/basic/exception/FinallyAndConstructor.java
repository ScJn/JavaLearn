package basic.exception;

import java.util.Random;

public class FinallyAndConstructor {

    FinallyAndConstructor(){
        Random random = new Random(5);
        int i = random.nextInt(10);


        if(i<6)throw new RuntimeException();
    }
    public static void main(String[] args) {

        FinallyAndConstructor finallyAndConstructor = new FinallyAndConstructor();

    }
}
