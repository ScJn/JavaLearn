package basic.String;

public class UnintendedRecursion {

    @Override
    public String toString() {
//        return "a" + this;
        return "a" + super.toString();
    }

    UnintendedRecursion(){

    }

    public static void main(String[] args) {
        UnintendedRecursion unintendedRecursion = new UnintendedRecursion();
        System.out.println(unintendedRecursion);
    }
}
