package java8.optional;

import java.util.Optional;

public class Fair {
    private String isThereFair;
    public String justis;

    public Fair(String isThereFair) {
        this.isThereFair = isThereFair;
    }

    public Optional<String> getJustis() {
        return Optional.ofNullable(justis);
    }

    public Fair(){

    }

    public String getIsThereFair() {
        return isThereFair;
    }

    public void setIsThereFair(String isThereFair) {
        this.isThereFair = isThereFair;
    }

    public static void main(String[] args) {

        Fair fair = new Fair();
        System.out.println(fair.getIsThereFair());
    }
}
