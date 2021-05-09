package design_pattern.singleton_pattern;

public class StaticInternalClass {

    private static class StaticInternalClassInstance{
        private static final StaticInternalClass instance=new StaticInternalClass();
    }

    private StaticInternalClass(){}

    public static StaticInternalClass getInstance(){
        return StaticInternalClassInstance.instance;
    }

}

class T1{
    public static void main(String[] args) {
        StaticInternalClass s=StaticInternalClass.getInstance();
        StaticInternalClass s2=StaticInternalClass.getInstance();
        System.out.println(s.hashCode()+" "+s2.hashCode());

    }
}
