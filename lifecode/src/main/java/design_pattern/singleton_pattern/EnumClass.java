package design_pattern.singleton_pattern;

public enum  EnumClass {

    INSTANCE;
    public void operation(){}
}

class T2{
    public static void main(String[] args) {
        EnumClass enumClass=EnumClass.INSTANCE;
        EnumClass e2=EnumClass.INSTANCE;
        enumClass.operation();

        System.out.println(enumClass.hashCode()+" "+e2.hashCode());
    }
}