package basic.interfaceLearn;

public class InterfaceInheritance {

    public static void main(String[] args) {
        UpInterface up = new UpClass();
        up.base();
        MiddleInterface middle = new UpClass();
        BaseInterface base = new UpClass();
        base.base();
        System.out.println(BaseInterface.A);
        System.out.println(base.A);
    }

}

interface BaseInterface{
    int A = 4;
    void base();
}
interface MiddleInterface {
    void middle();
}

interface UpInterface extends BaseInterface, MiddleInterface {
    void up();
}
class UpClass implements UpInterface {

    @Override
    public void base() {
        System.out.println("base");
    }

    @Override
    public void middle() {

    }

    @Override
    public void up() {

    }
}