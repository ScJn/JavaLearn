package basic.runtimeTypeInfo.nullObject;

public class Person {
    private int num;
    private String name;
    public static final Person NULL = new NullPerson();

    static class NullPerson extends Person implements Null {
        NullPerson(){
            super(0,"None");
        }

        @Override
        public String toString() {
            return "null person";
        }
    }


    public Person(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public static void main(String[] args) {
        Person person = Person.NULL;
        System.out.println(person.toString());
        if (person instanceof Null) {
            person = new Person(1,"sd");
        }
        System.out.println(person.toString());
    }
}
