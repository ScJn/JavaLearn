package design_pattern.builder;

public class TestBuilder {
    public static void main(String[] args) {
        IPhoneDirector director=new IPhoneDirector();

        Iphone iphone=director.directPhone();
        System.out.println(iphone.getClass().getName());
        System.out.println(iphone.getCpu().getClass().getName());

    }
}
