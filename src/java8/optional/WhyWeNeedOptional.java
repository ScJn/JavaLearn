package java8.optional;

import java.util.Optional;

public class WhyWeNeedOptional {

    public static void main(String[] args) {
//        testFilter();

        thePowerOfOptional();

    }

    private static void thePowerOfOptional() {
        Person person = getPerson();

        String aNull = Optional.of(person)
                .flatMap(Person::getOptionalCar)
                .map(Car::getInsurance)
                .map(insurance -> insurance.name)
                .orElse("NULL");

        System.out.println(aNull);
    }

    private static void withoutOptional(){
        Person person = getPerson();
        if(person!=null){
            Car car = person.getCar();
            if(car!=null){
                Insurance insurance = car.getInsurance();
                if(insurance!=null){
                    System.out.println(insurance.name);
                }
            }
        }
    }

    private static Person getPerson() {
        Car c = new Car();
        c.setInsurance(null);
        Person person = new Person();
        person.setCar(c);
        c.setInsurance(new Insurance("CC"));
        return person;
    }

    private static void testFilter() {
        Fair fair = new Fair("true");
        Optional<Fair> opFair = Optional.of(fair);
        Optional<Fair> opFair2 = Optional.empty();
        String aTrue = opFair.filter(fair1 -> fair1.getIsThereFair().equals("true")).map(fair1 -> "true").orElse("null");
        String aTrue2 = opFair2.filter(fair1 -> fair1.getIsThereFair().equals("true")).map(fair1 -> "true").orElse("null");
        System.out.println(aTrue);
        System.out.println(aTrue2);
    }
}
