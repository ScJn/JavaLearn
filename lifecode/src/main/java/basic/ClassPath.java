package basic;

public class ClassPath {

    public static void main(String[] args) {
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println(path);
    }
}
