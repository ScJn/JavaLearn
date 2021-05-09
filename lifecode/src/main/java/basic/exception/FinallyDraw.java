package basic.exception;

/**
 * lose exception
 */
public class FinallyDraw {

    public static void main(String[] args) {

        try {
            throw new RuntimeException();
        } finally {
            return;
        }
    }
}
