package design_pattern.proxy.staticProxy;

public class Proxy {
    public static void main(String[] args) {
        XiaoMin xiaoMin=new XiaoMin();
        new MarryCompany(xiaoMin).happyMarry();
    }

}

interface Marry {
    void happyMarry();
}

class XiaoMin implements Marry {

    @Override
    public void happyMarry() {
        System.out.println("XiaoMin Marry");
    }
}

class MarryCompany implements Marry{
    private Marry person;
    public MarryCompany(Marry person){
        this.person=person;
    }

    private void doBefore(){
        System.out.println("buy cookie");
    }
    private void doAfter(){
        System.out.println("send customer");
    }

    @Override
    public void happyMarry() {
        doBefore();
        person.happyMarry();
        doAfter();
    }
}
