package java8.optional;

import java.util.Optional;

public class HardWork {

    private Fair fair;

    public HardWork(Fair fair) {
        this.fair = fair;
    }


    public static void main(String[] args) {
//        executeFairWithOptional(null);
//        executeHardWork(new HardWork(null));
        executeHardWorkWithOptional(new HardWork(new Fair( )));
    }

    static void executeFairWithOptional(Fair f) {
        Optional<Fair> f1 = Optional.ofNullable(f);
        Optional<String> u = f1.map(Fair::getIsThereFair);
        Optional<Optional<String>> s = f1.map(Fair::getJustis);
        Optional<String> s1 = f1.flatMap(Fair::getJustis);         // use flatMap to avoid multi-option
        String a = s1.orElseThrow(() -> new RuntimeException("null"));
        String aa = u.orElseThrow(() -> new RuntimeException("isThereFair is null"));
        System.out.println(a);
        System.out.println(aa);
    }

    static void executeHardWork(HardWork hardWork) {
        if (hardWork == null) throw new RuntimeException("hardWork is null");
        Fair fair = hardWork.getFair();
        if (fair == null) throw new RuntimeException("fair is null");
        String isThereFair = fair.getIsThereFair();
        if (isThereFair == null) throw new RuntimeException("isThereFair is null");
        else {
            System.out.println(isThereFair);
        }
    }

    static void executeHardWorkWithOptional(HardWork hardWork) {
        Optional<String> s = Optional.ofNullable(hardWork).map(HardWork::getFair).map(Fair::getIsThereFair);
        System.out.println(s.orElseThrow(() -> new RuntimeException("some one is null")));
    }

    static void executeFair(Fair f) throws Exception {
        if (f == null) {
            throw new Exception("fair is null");
        }
        String isThereFair = f.getIsThereFair();
        Optional<String> justis = f.getJustis();
        if (justis.isPresent()) {
            String s = justis.get();
        } else {
            throw new RuntimeException("justis is null");
        }
        System.out.println(isThereFair);
    }


    public Fair getFair() {
        return fair;
    }

    public void setFair(Fair fair) {
        this.fair = fair;
    }
}
