package design_pattern.decorator;


/**
 * concrete component
 * @see java.io.FileInputStream
 * implements the abstract component
 * @see java.io.InputStream
 * override some abstract method, then will be used as a parameter pass to
 * the concrete decoretor component constructor
 *
 */
public class Dog implements Animal {

    @Override
    public void hum() {
        System.out.println("wang wang");
    }
}
